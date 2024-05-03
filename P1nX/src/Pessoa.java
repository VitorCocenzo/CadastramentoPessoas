import java.util.GregorianCalendar;

public class Pessoa {
    private String nome,sobreNome;
    private GregorianCalendar dataNasc;
    private long numCPF;
    private float peso, altura;
    private static int numPessoas;

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano){
        if(!ValidaData.isAno(ano) || !ValidaData.isDia(dia) || !ValidaData.isMes(mes)){
            throw new IllegalArgumentException("Data invalida");
        }

        numPessoas++;
        this.setNome(nome);
        this.setSobreNome(sobreNome);
        this.dataNasc = new GregorianCalendar(ano, mes-1, dia);

        try{
            dataNasc.setLenient(false);
        }catch(IllegalArgumentException e){
            System.out.println("Data invalida");
        }

    }

    public Pessoa(String nome, String sobreNome, int dia, int mes, int ano, long numCPF, float peso, float altura){
        if(!ValidaData.isAno(ano) || !ValidaData.isDia(dia) || !ValidaData.isMes(mes)){
            throw new IllegalArgumentException("Data invalida");
        }

        if(!ValidaCPF.isCPF(Long.toString(numCPF))){
            throw new IllegalArgumentException("CPF invalidado");
        }

        numPessoas++;
        this.setNome(nome);
        this.setSobreNome(sobreNome);

        if(altura<2.8 && altura>=0.5){
            this.setAltura(altura);
        }else{
            throw new IllegalArgumentException("Altura invalida.");
        }

        if(peso<400 && peso>=5){
            this.setPeso(peso);
        }else{
            throw new IllegalArgumentException("Peso invalido");
        }

        this.setNumCPF(numCPF);
        this.dataNasc = new GregorianCalendar(ano, mes-1, dia);

        /*try{
            this.dataNasc = new GregorianCalendar(ano, mes-1, dia);
            dataNasc.setLenient(false);
        }catch(IllegalArgumentException e){
            System.out.println("Data invalida");
            }*/
    }

    public static int numPessoas(){
        return numPessoas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public GregorianCalendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(int dia, int mes, int ano) {
        this.dataNasc = new GregorianCalendar(ano, mes-1, dia);
    }

    public long getNumCPF() {
        return numCPF;
    }

    public void setNumCPF(long numCPF) {
        this.numCPF = numCPF;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "--------------------------\n Pessoa [Nome=" + nome + ", Sobrenome=" + sobreNome + "\n         DataNasc=" + dataNasc.get(GregorianCalendar.DAY_OF_MONTH)+ "/" + 
        (dataNasc.get(GregorianCalendar.MONTH)+1)+"/"+ dataNasc.get(GregorianCalendar.YEAR) + "\n         NumCPF=" + numCPF + "\n         Peso=" + peso + "Kg" +
        "\n         Altura=" + altura + "m";
    }
    
}
