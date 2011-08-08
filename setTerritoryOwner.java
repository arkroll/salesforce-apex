trigger setTerritoryOwner on Lead (After update) {

    List<Lead> leads = new List<Lead>();

    for(Lead lead : Trigger.new){
    
        Lead oldMap = Trigger.oldMap.get(lead.Id);
        
        if (SetTerritoryOwnerUtil.firstTime = True){
            if(oldMap.Phone != lead.Phone || oldMap.Street != lead.Street || oldMap.Country != lead.Country || oldMap.PostalCode != lead.PostalCode || oldMap.State != lead.State || oldMap.Company != lead.Company){
                List<User> oW = new List<User>();
                for (User u : OwnerUtil.getTerritoryOwners(lead)){
                    ow.add(u);
                }
                User newOwner = oW[math.round(math.random()*oW.size())-1];
                lead.territory_owner__c = newOwner.Id;
                leads.add(lead);
            }
        }
            
    }
    SetTerritoryOwnerUtil.firstTime = False;
    Database.Update(leads);

}