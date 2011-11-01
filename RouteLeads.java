trigger RouteLeads on Lead (After update) {

    Map<ID, Integer> leadChange = new Map<ID, Integer>();

    Map<ID, Set<Lead>> routerQueue = new Map<ID, Set<Lead>>();

    Set<Lead> assignQueue = new Set<Lead>();

    Set<Lead> newLeads = new Set<Lead>();

    for (Lead lead : Trigger.new) {
                
        String newOwnerId = lead.OwnerId;
        System.debug(newOwnerId);
        String oldOwnerId = Trigger.oldMap.get(lead.Id).OwnerId;
        System.debug(oldOwnerId);
        
        if(LeadUtil.getRTR(lead) && lead.ISConverted == false && newOwnerId.startsWith('005A') == false && newOwnerId.startsWith('00GA0000000YKi3') && LeadAssignUtil.firstTime == true){
            System.debug(lead.Name + 'Qualifies');
            if(LeadUtil.routeBy(lead) == 'Route Randomly'){
                MapUtil.mapUpdate(routerQueue, lead.territory_owner__r.Id, lead, 'add');
                MapUtil.mapUpdate(leadChange, lead.territory_owner__r.Id, 1, '$inc');
            }
            else if(LeadUtil.routeBy(lead) == 'Use Default Assignment Rule'){
                assignQueue.add(lead);
            }
            else if(LeadUtil.routeBy(lead) == 'Assign to Campaign Owner'){
                for (Lead aLead : LeadUtil.changeOwner(lead, LeadUtil.campaignOwner(lead))){
                    newLeads.add(aLead);
                }
                MapUtil.mapUpdate(leadChange, LeadUtil.campaignOwner(lead), 1, '$inc');
            }
            else{
                System.debug('Campaign Member routing type not specified');
            }
        }
        else if((LeadUtil.mvRepToRep(oldOwnerId, newOwnerId) || LeadUtil.mvToQueue(oldOwnerId, newOwnerId) || Lead.ISConverted) && LeadAssignUtil.firstTime == True){
            String name = lead.Name;
            System.debug(lead.name + 'Qualifies');
            MapUtil.mapUpdate(leadChange, Trigger.oldMap.get(lead.Id).OwnerId, -1, '$inc');
        }
        else{
            System.debug(lead.Name + 'does not qualify');
        }
    }

    if (leadChange.keySet().isEmpty() == false){
        
        for (ID idVal : leadChange.keySet()) {
            if (leadChange.get(idVal) < 0){
                User owner = [SELECT Id, Routing__c FROM User WHERE Id = :idVal];
                if (owner.Routing__c == 'Route Randomly'){
                    MapUtil.mapUpdate(routerQueue, idVal, OwnerUtil.getLeads(leadChange, idVal), 'add');
                }
            }
        }
         
        System.debug('routerQueue: ' + routerQueue + ' assignQueue: ' + assignQueue);
        
        if (routerQueue.keySet().isEmpty() == false){
            for (Lead aLead : LeadUtil.changeOwner(routerQueue)){
                newLeads.add(aLead);
            }
        }

        if (assignQueue.isEmpty() == false){
            for (Lead aLead : LeadUtil.runRules(assignQueue)){
                newLeads.add(aLead);
            }
        }
        
        List<Lead> newLeadsList = new List<Lead>();
        
        if (newLeads.isEmpty() == false){
            for (Lead aLead : newLeads){
                newLeadsList.add(aLead);
            }
        }

        LeadAssignUtil.firstTime = false;
            
        Database.Update(newLeadsList);

    }
        
}