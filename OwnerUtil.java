public class OwnerUtil{
    public static Set<Lead> getLeads(Map<ID, Integer> m, ID id) {
        Set<Lead> leads = new Set<Lead>();
        String anId = id;
        if (anId.length() > 15){
            id = anId.substring(0,15);
        }
        Integer ownedLeads = [SELECT Count() FROM Lead WHERE OwnerId = :id AND ISConverted = False];
        User u = [SELECT Queue_Size__c FROM User WHERE Id = :id];
        
        if (ownedLeads < u.Queue_Size__c){
            Integer numLeads = -1*(m.get(id));
            if (numLeads > 0){
                List<Lead> newLeads = [SELECT Id, OwnerId, mkto_si__Priority__c, mkto2__Lead_Score__c FROM Lead WHERE territory_owner__r.Id = :id AND OwnerId = '00GA0000000Y0Ep' AND mkto_si__Priority__c != null AND mkto2__Lead_Score__c !=null ORDER BY mkto_si__Priority__c, mkto2__Lead_Score__c DESC LIMIT :numLeads];
                for (Lead aLead : newLeads){
                    leads.add(aLead);
                }
            }
        }
        return leads;
    }
    
    public static Set<User> getTerritoryOwners(Lead lead) {
        Set<User> territoryOwners = new Set<user>();
        String pc = lead.PostalCode;
        String sT = lead.State;
        String cO = lead.Country;
                   
        List<User> stU = [SELECT Id FROM User WHERE americas_territory__c INCLUDES (:cO) AND state_territory__c INCLUDES (:sT)];
        
        if(stU.isEmpty() == False){
            for (User u : stU){
                String s = (u.postalcode_territory__c).replaceAll(' ', '');
                Set<String> codes = new Set<String>();
                for (String code : s.split('\n')){
                    if (code.contains('-')){
                        Integer first = integer.valueof(code.split('-')[0]);                        
                        Integer last = integer.valueof(code.split('-')[1]);
                        for (Integer x = first; x <= last; x ++){
                            String y = String.valueof(x);
                            if (y.length() < 5){
                                y = '0' + y;
                            }
                            codes.add(y);
                        }
                    }
                    else{
                        codes.add(code);
                    }
                }
                for (String aCode : codes){
                    if (aCode == pc){
                        territoryOwners.add(u);
                    }
                }
            }
                                 
            if (territoryOwners.isEmpty() == False){
                return territoryOwners;
            }
            else {
                for (User u : stU){
                    territoryOwners.add(u);
                }
                return territoryOwners;
            }
        }    
        else {
            List<User> cU = [Select Id FROM User WHERE americas_territory__c INCLUDES (:cO) OR apac_territory__c INCLUDES (:cO) OR emea_territory__c INCLUDES (:cO)];
            if (cU.isEmpty() == False) {
                for (User u : cU){
                    territoryOwners.add(u);
                }
                return territoryOwners;
            }
            else{
                return territoryOwners;
            }
        }
    } 
   
                
            
}