package funcionalidades;

public class funcionalidad {
    public boolean palindromo(String cadena){
        String di = new String();
        String dr = new String();
        for (int i = 0; i < cadena.length() ; i++) {
            String temp = new String();
            temp = cadena.substring(i, i+1);
            if (temp.compareTo(" ")!= 0) {// 0 igual y 1 diferente
                di = di + temp;
                dr = temp + dr;
            }
        }
        if (di.compareTo(dr) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int mayorV(int[] vector, int tamaño){
        int may = vector[0];
        for (int k = 1; k <= tamaño+1; k++) {
            if (vector[k]> may){
                may = vector[k];
            }
        }
        return may;
    }

    public int encontrarV(int[] vector, int tamaño, int buscar){
        int sw = 0, i = 1;
        while (i <= tamaño && sw == 0){
            if (buscar == vector[i]){
                sw = 1;
            } else {
                i++;
            }    
        }
        if (sw == 0){
            return -1;
        } else{
            return i;
        }
    }
    public String deci_bina(int decimal){
        int pro = decimal;
        String binario = "";
        while(pro > 0){
            binario = (pro % 2) + binario;
            pro = pro / 2;
        }
        return binario;
    }
}
