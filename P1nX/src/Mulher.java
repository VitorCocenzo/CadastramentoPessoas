import java.util.GregorianCalendar;

public class Mulher extends Pessoa {
    private String genero;
    private GregorianCalendar dataAtual = new GregorianCalendar();
    private GregorianCalendar dataNasc;
    private int idade;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Mulher(String nome, String sobreNome, int dia, int mes, int ano) {
        super(nome, sobreNome, dia, mes, ano);

        if(!ValidaData.isDataValida(dia, mes, ano)){
            throw new IllegalArgumentException("Data invalida");
        }

        if(!ValidaData.isAno(ano)){
            throw new IllegalArgumentException("Ano invalido. O ano tem que ser pelo menos de 120 anos atras ate os dias atuais");
        }

        this.setGenero("Mulher");
        this.dataNasc = new GregorianCalendar(ano, mes-1, dia);
        
        /*testando o metodo setLenient
        try{
            dataNasc.setLenient(false);
        }catch(IllegalArgumentException e){
            System.out.println("Data invalida");
        }*/
        
    }

    public Mulher(String nome, String sobreNome, int dia, int mes, int ano, long CPF, float peso, float altura) {
        super(nome, sobreNome, dia, mes, ano, CPF, peso, altura);

        if(!ValidaData.isDataValida(dia, mes, ano)){
            throw new IllegalArgumentException("Data invalida");
        }

        if(!ValidaData.isAno(ano)){
            throw new IllegalArgumentException("Ano invalido. O ano tem que ser pelo menos de 120 anos atras ate os dias atuais");
        }


        this.setGenero("Mulher");
        this.dataNasc = new GregorianCalendar(ano, mes-1, dia);

        /*testando o metodo setlenient
        try{
            dataNasc.setLenient(false);
        }catch(IllegalArgumentException e){
            System.out.println("Data invalida");
        }*/
    }

    private String calcularIdade(){
        this.idade = dataAtual.get(GregorianCalendar.YEAR)-dataNasc.get(GregorianCalendar.YEAR);
        
        if(idade>120 || idade<0){
            return "Idade invalida";
        }else if(dataNasc.get(GregorianCalendar.MONTH)>dataAtual.get(GregorianCalendar.MONTH)){
            return String.valueOf(this.idade-1);
        }else if(dataNasc.get(GregorianCalendar.MONTH)==dataAtual.get(GregorianCalendar.MONTH)){
            if((dataNasc.get(GregorianCalendar.DAY_OF_MONTH))<= dataAtual.get(GregorianCalendar.DAY_OF_MONTH)){
                return String.valueOf(this.idade);
            }else{
                return String.valueOf(this.idade-1);
            }
        }return String.valueOf(this.idade);
    }

    @Override
    public String toString() {
        return super.toString() + "\n         Genero=" + genero + "\n         Idade=" + calcularIdade() + "]";
    }
}
