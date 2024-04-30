public class MesesConstantes {
    public static int verificarMes(String mes){
        int auxiliar;
        switch (mes) {
            case "JANEIRO":
                auxiliar= 1;
                break;
            case "FEVEREIRO":
                auxiliar= 2;
                break;
            case "MARCO":
                auxiliar =3;
                break;
            case "ABRIL":
                auxiliar =4;
                break;
            case "MAIO":
                auxiliar =5;
                break;
            case "JUNHO":
                auxiliar =6;
                break;
            case "JULHO":
                auxiliar =7;
                break;
            case "AGOSTO":
                auxiliar =8;
                break;
            case "SETEMBRO":
                auxiliar =9;
                break;
            case "OUTUBRO":
                auxiliar =10;
                break;
            case "NOVEMBRO":
                auxiliar =11;
                break;
            case "DEZEMBRO":
                auxiliar=12;
                break;
            default:
                auxiliar = Integer.parseInt(mes);
                break;
        }
        return auxiliar;
    }
}
