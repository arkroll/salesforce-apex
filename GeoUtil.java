public class GeoUtil{
    
    public static Set<String> listRange(String range){
        Integer first = integer.valueof(range.split('-')[0]);
        Integer last = integer.valueof(range.split('-')[1]);
        Set<String> rangeList = new Set<String>();
        for (Integer x = first; x <= last; x ++){
            String y = String.valueof(x);
            if (range.startsWith('0')){
                y = '0' + y;
                rangeList.add(y);
            }
            else{
                rangeList.add(y);
            }
        }
        return rangeList;
    }
                 

    public static String getState(String zipcode){
        String zip = zipcode.substring(0,5);
        if (listRange('039-049').contains(zip.substring(0,3)){
            return 'ME';
        else if (listRange('039-049').contains(zip.substring(0,3)){
            return 'ME';


    public static String getProvince(String pc){
    }
