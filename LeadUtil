public class LeadUtil {

    public static Boolean getRTR(Lead lead) {
    
        Boolean u = False;
    
        List<CampaignMember> aM = [Select Id FROM CampaignMember WHERE LeadId = :lead.Id AND route_to_rep_yn__c = 'Yes'];
        
        if(aM.isEmpty() != True){
            u = True;
            return u;
        }
        return u;
    }
    
    public static Boolean mvRepToRep(String oldOwner, String newOwner) {
        if(oldOwner != newOwner){
            if (oldOwner.startsWith('005A') && newOwner.startsWith('005A')){
                return True;
            }
            else{
                return False;
            }
        } 
        else{
            return False;
        }    
    }    
     
    public static Boolean mvToQueue(String oldOwner, String newOwner) {
        if(oldOwner != newOwner){
            if(newOwner.startsWith('00GA0000002FEzJ') || newOwner.startsWith('00GA0000000YKi3')){
                return True;
            }
            else{
                return False;
            }
        }
        else{
            return False;
        }
    }
    
    public static Boolean isInQueue(Lead lead){
    
        String owner = lead.OwnerId;
        
        if(owner.startsWith('00GA')){
            return True;
        }
        else{
            return False;
        }
    }   
    
    public static Lead changeOwner(Lead lead, ID id){
        lead.OwnerID = id;
        lead.Admin_HEBA_YN__c = True;
        return lead;
    }
    
    
    public static Set<Lead> changeOwner(Map<ID, Set<Lead>> m){
        Set<Lead> newLeads = new Set<Lead>();
        for (ID aId : m.keySet()){
            for (Lead aLead : m.get(aId)){
                aLead.OwnerId = aId;
                aLead.Admin_HEBA_YN__c = True;
                newLeads.add(aLead);
            }
        }
        return newLeads;
    }   
     
    public static lead runRules(Lead lead){
        Database.DMLOptions dmo = new Database.DMLOptions();
        dmo.assignmentRuleHeader.useDefaultRule= true;    
        lead.setOptions(dmo);
        lead.Admin_HEBA_YN__c = True;
        return lead;
    }
    
    public static Set<Lead> runRules(Set<Lead> m){
        Set<Lead> newLeads = new Set<Lead>();
        Database.DMLOptions dmo = new Database.DMLOptions();
        dmo.assignmentRuleHeader.useDefaultRule= true;
        for (Lead aLead : m){
             aLead.setOptions(dmo);
             aLead.Admin_HEBA_YN__c = True;
             newLeads.add(aLead);
        }
        return newLeads;
    }
    
    public static ID campaignOwner(Lead lead){
        CampaignMember a = [Select CampaignId FROM CampaignMember WHERE LeadId = :lead.Id AND route_to_rep_yn__c = 'Yes' ORDER BY SystemModstamp LIMIT 1];
        Id id = a.Campaign_Owner__c;
        return id;
    }
    
    public static String routeBy(Lead lead){
        CampaignMember a = [Select CampaignId FROM CampaignMember WHERE LeadId = :lead.Id AND route_to_rep_yn__c = 'Yes' ORDER BY SystemModstamp DESC LIMIT 1];
        return a.Member_Routing__c;
    }
    
}
