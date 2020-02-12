package hu.exth.l4tgt.model.Trigger;


public interface StringMethods {
    static String getName(String original) {
        int i=0;
        for(char c: original.toCharArray()){
            if(c==':'){
                return original.substring(0,i);
            }
            i++;
        }
        throw new IllegalArgumentException("There is no \':\' char in the string: "+original);
    }

    static String getValue(String original){
        int i=0;
        for(char c: original.toCharArray()){
            if(c==':'){
                return original.substring(i+1);
            }
            i++;
        }
        throw new IllegalArgumentException("There is no \':\' char in the string: "+original);
    }

}
