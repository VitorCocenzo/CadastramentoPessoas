import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class P1nX {
    public static void main(String[] args) throws Exception {

        String genero_incial;

        try{
            /*
             * Verifica o tamanho de args, caso seja igual a 9, quer dizer que o cpf foi inserido todo de uma vez
             */
            if(args.length == 9){

                genero_incial = args[0];
                genero_incial = genero_incial.toUpperCase();

                String mes_String = args[4].toUpperCase();
                int auxiliarMes;

                auxiliarMes = MesesConstantes.verificarMes(mes_String);
                long auxiliarCPF = ValidaCPF.toLong(args[6]);

                if(!args[1].matches("^[a-zA-Z]+$") || !args[2].matches("^[a-zA-Z]+$")){
                    System.out.println("Nome invalido, o nome deve ser apenas alfabetico\n");
                    throw new IllegalArgumentException();    

                }

                if(!ValidaData.isDia(args[3])){
                    System.out.println("Dia invalido, o dia deve estar entre 1 e 31\n");
                    throw new IllegalArgumentException();    

                }else if(args[4].matches("^[a-zA-Z]+$")){
                    auxiliarMes = MesesConstantes.verificarMes(mes_String);
                }else if(args[4].matches("^[0-9]+")){
                    auxiliarMes = Integer.parseInt(args[4]);
                }else if(!ValidaData.isAno(args[5])){
                    System.out.println("Ano invalido, a pessoa tem que ter ate 120 anos\n");
                    throw new IllegalArgumentException();    

                }

                if(!ValidaData.isDataValida(Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]))){
                    System.out.println("A data: " + Integer.parseInt(args[3]) + "/" + auxiliarMes + "/" + Integer.parseInt(args[5]) + " nao e valida\n");
                    throw new IllegalArgumentException();    

                }

                if(!ValidaCPF.isCPF(args[6])){
                    System.out.println("CPF invalido\n");
                    throw new IllegalArgumentException();    

                }

                if(Float.parseFloat(args[7])>= 400 || Float.parseFloat(args[7])<5){
                    System.out.println("Peso invalido\n");
                    throw new IllegalArgumentException();    

                }

                if(Float.parseFloat(args[8])>2.8 || Float.parseFloat(args[8])<0.5){
                    System.out.println("Altura invalida\n");
                    throw new IllegalArgumentException();    

                }

                if(!genero_incial.equals("HOMEM") && !genero_incial.equals("MULHER")){
                    System.out.println("ERRO! O genero deve ser Homem ou Mulher\n");
                    throw new IllegalArgumentException();

                }else if(genero_incial.equals("HOMEM")){
                    Homem exemplo = new Homem(args[1], args[2], Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]), auxiliarCPF, 
                    Float.parseFloat(args[7]), Float.parseFloat(args[8]));

                    System.out.println(exemplo.toString());

                }else{
                    Mulher exemplo = new Mulher(args[1], args[2], Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]), auxiliarCPF,
                    Float.parseFloat(args[7]), Float.parseFloat(args[8]));

                    System.out.println(exemplo.toString());
                }
                /*
                 * verifica o tamanho do args, caso seja igual a 10, quer dizer que o cpf foi inserido no estilo 123456789 10
                 */
            }else if(args.length == 10){
                genero_incial = args[0];
                genero_incial = genero_incial.toUpperCase();

                String mes_String = args[4].toUpperCase();
                int auxiliarMes;

                auxiliarMes = MesesConstantes.verificarMes(mes_String);

                if(!args[1].matches("^[a-zA-Z]+$") || !args[2].matches("^[a-zA-Z]+$")){
                    System.out.println("Nome invalido, o nome deve ser apenas alfabetico\n");
                    throw new IllegalArgumentException();    

                }

                if(!ValidaData.isDia(args[3])){
                    System.out.println("Dia invalido, o dia deve estar entre 1 e 31\n");
                    throw new IllegalArgumentException();    

                }else if(args[4].matches("^[a-zA-Z]+$")){
                    auxiliarMes = MesesConstantes.verificarMes(mes_String);
                }else if(args[4].matches("^[0-9]+")){
                    auxiliarMes = Integer.parseInt(args[4]);
                }else if(!ValidaData.isAno(args[5])){
                    System.out.println("Ano invalido, a pessoa tem que ter ate 120 anos\n");
                    throw new IllegalArgumentException();    

                }

                if(!ValidaData.isDataValida(Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]))){
                    System.out.println("A data: " + Integer.parseInt(args[3]) + "/" + auxiliarMes + "/" + Integer.parseInt(args[5]) + " nao e valida\n");
                    throw new IllegalArgumentException();    

                }

                if(!ValidaCPF.isCPF(args[6]+args[7])){
                    System.out.println("CPF invalido\n");
                    throw new IllegalArgumentException();    

                }
                long auxiliarCPF = ValidaCPF.toLong(args[6] + args[7]);

                if(Float.parseFloat(args[8])>= 400 || Float.parseFloat(args[8])<5){
                    System.out.println("Peso invalido\n");
                    throw new IllegalArgumentException();    

                }

                if(Float.parseFloat(args[9])>2.8 || Float.parseFloat(args[9])<0.5){
                    System.out.println("Altura invalida\n");
                    throw new IllegalArgumentException();    

                }

                if(!genero_incial.equals("HOMEM") && !genero_incial.equals("MULHER")){
                    System.out.println("ERRO! O genero deve ser Homem ou Mulher\n");
                    throw new IllegalArgumentException();

                }else if(genero_incial.equals("HOMEM")){
                    Homem exemplo = new Homem(args[1], args[2], Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]), auxiliarCPF, 
                    Float.parseFloat(args[8]), Float.parseFloat(args[9]));

                    System.out.println(exemplo.toString());

                }else{
                    Mulher exemplo = new Mulher(args[1], args[2], Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]), auxiliarCPF,
                    Float.parseFloat(args[8]), Float.parseFloat(args[9]));

                    System.out.println(exemplo.toString());
                }
                /*
                 * verifica se o tamanho do args e igual a 12, caso seja, o cpf foi passado do estilo 123 456 789 10
                 */
            }else if(args.length == 12){
                genero_incial = args[0];
                genero_incial = genero_incial.toUpperCase();

                String mes_String = args[4].toUpperCase();
                int auxiliarMes;

                auxiliarMes = MesesConstantes.verificarMes(mes_String);

                if(!args[1].matches("^[a-zA-Z]+$") || !args[2].matches("^[a-zA-Z]+$")){
                    System.out.println("Nome invalido, o nome deve ser apenas alfabetico\n");
                    throw new IllegalArgumentException();    

                }

                if(!ValidaData.isDia(args[3])){
                    System.out.println("Dia invalido, o dia deve estar entre 1 e 31\n");
                    throw new IllegalArgumentException();    

                }else if(args[4].matches("^[a-zA-Z]+$")){
                    auxiliarMes = MesesConstantes.verificarMes(mes_String);
                }else if(args[4].matches("^[0-9]+")){
                    auxiliarMes = Integer.parseInt(args[4]);
                }else if(!ValidaData.isAno(args[5])){
                    System.out.println("Ano invalido, a pessoa tem que ter ate 120 anos\n");
                    throw new IllegalArgumentException();    

                }

                if(!ValidaData.isDataValida(Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]))){
                    System.out.println("A data: " + Integer.parseInt(args[3]) + "/" + auxiliarMes + "/" + Integer.parseInt(args[5]) + " nao e valida\n");
                    throw new IllegalArgumentException();    

                }

                if(!ValidaCPF.isCPF(args[6]+args[7]+args[8]+args[9])){
                    System.out.println("CPF invalido\n");
                    throw new IllegalArgumentException();    

                }
                long auxiliarCPF = ValidaCPF.toLong(args[6]+args[7]+args[8]+args[9]);

                if(Float.parseFloat(args[10])>= 400 || Float.parseFloat(args[10])<5){
                    System.out.println("Peso invalido\n");
                    throw new IllegalArgumentException();    

                }

                if(Float.parseFloat(args[11])>2.8 || Float.parseFloat(args[11])<0.5){
                    System.out.println("Altura invalida\n");
                    throw new IllegalArgumentException();    

                }

                if(!genero_incial.equals("HOMEM") && !genero_incial.equals("MULHER")){
                    System.out.println("ERRO! O genero deve ser Homem ou Mulher\n");
                    throw new IllegalArgumentException();

                }else if(genero_incial.equals("HOMEM")){
                    Homem exemplo = new Homem(args[1], args[2], Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]), auxiliarCPF, 
                    Float.parseFloat(args[10]), Float.parseFloat(args[11]));

                    System.out.println(exemplo.toString());

                }else{
                    Mulher exemplo = new Mulher(args[1], args[2], Integer.parseInt(args[3]), auxiliarMes, Integer.parseInt(args[5]), auxiliarCPF,
                    Float.parseFloat(args[10]), Float.parseFloat(args[11]));

                    System.out.println(exemplo.toString());
                }
                /*
                 * caso o args tenha tamanho diferente dos mostrados acima, imprime um "help"
                 */
            }else{
                System.out.println("ERRO!\nFormatação experada: java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>\n");
            }
            
        }catch(NumberFormatException nf){
            System.out.println("Formatação experada: java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>\n");
        }catch (IllegalArgumentException i) {
            System.out.println("Formatação experada: java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>\n");
        }catch(InputMismatchException in){
            System.out.println("Formatação experada: java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>\n");
        }

        @SuppressWarnings("resource")
        Scanner teclado = new Scanner(System.in);

        String elem; 
        int count= 0, HomemCount= 0, MulherCount = 0, contador_elementos = 0;
        String genero = "";


        try {
            /*
             * Criar um array com o numero de elementos indicado pelo usuario
             * numero de elemtnos tem que ser maior ou igual a 0
             * tem que ser um inteiro, nao uma string
             */
            System.out.println("Quantos elementos adicionais serão criados no array?(Inteiro positivo)");
            elem = teclado.next();
            teclado.nextLine();

            if(!elem.matches("-?\\d+")){
                while(contador_elementos<3){
                    System.out.println("Index do Array deve ser um numero, positivo, tente novamente(1 tentativa).");
                    elem = teclado.next();
                    teclado.nextLine();

                    if(elem.matches("\\d+")){
                        if(Integer.parseInt(elem)>=0){
                            break;
                        }else{
                            contador_elementos++;
                            System.out.println("Index do array deve ser um numero, positivo, tente novamente(1 tentativa).");
                            elem = teclado.next();
                            teclado.nextLine();
                            if(Integer.parseInt(elem)<0 || !elem.matches("\\d+")){
                                System.out.println("Nao aceitarei mais erros(encerrando...)");
                                break;
                            }
                        }
                    }else{
                        System.out.println("Nao aceitarei mais erros(encerrando...)");
                        break;
                    }
                    contador_elementos++;
                }
            }else if(Integer.parseInt(elem)<0){
                while(contador_elementos<3){
                    System.out.println("Index do Array deve ser um numero, positivo, tente novamente.");
                    elem = teclado.next();
                    teclado.nextLine();
                    contador_elementos++;

                    if(!elem.matches("\\d+")){
                        System.out.println("Index do Array deve ser um numero, positivo. Tente Novamente");
                        elem = teclado.next();
                        teclado.nextLine();
                        if(Integer.parseInt(elem)>=0){
                            break;
                        }else{
                            System.out.println("Nao aceitarei mais erros(encerrando...)");
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }

            Pessoa array2[] = new Pessoa[Integer.parseInt(elem)];

            /*
             * Saber o genero da pessoa para que se possa instanciar corretamnete
             * Genero tem que ser Homem ou Mulher
             */
            for (int i = 0; i < (array2.length) && !genero.equals("NEUTRO"); i++) {
                String nome, sobrenome;
                int dia= -1, ano = -1, mes = -1; //inicializa a data com valores absurdos
                String mes_String, dia_String, ano_String;

                System.out.println("Qual o genero da próxima pessoa?(Homem ou Mulher)('neutro' interrompe)");
                genero = teclado.next().toUpperCase();
                teclado.nextLine();

                if(genero.equals("NEUTRO")){
                    System.out.println("Genero NEUTRO(encerrando...)");
                    break;
                }

                if(!genero.equals("HOMEM") && !genero.equals("MULHER") && !genero.equals("NEUTRO")){
                    while(contador_elementos<3){
                        System.out.println("Genero invalido, tente novamente. Tentativas restantes : " + (3-contador_elementos));
                        genero = teclado.next().toUpperCase();
                        teclado.nextLine();
                        if(genero.equals("HOMEM") || genero.equals("MULHER") || genero.equals("NEUTRO")){
                            break;
                        }
                        contador_elementos++;
                        
                    }  
                }
                if(contador_elementos == 3){
                    break;
                }
                contador_elementos = 0;

                if(genero.equals("NEUTRO")){
                    System.out.println("Genero NEUTRO(encerrando...)");
                    break;
                }
                /*
                 * Saber o primeiro nome da pessoa
                 * Nome tem quer ser apenas alfabetico
                 */
                System.out.print("Nome(Nao pode conter numeros nem cracteres especiais): ");
                nome = teclado.nextLine();

                if(!nome.matches("[A-Za-z]+(\\s+[A-Za-z]+)?")){
                    while(contador_elementos<3){
                        System.out.println("Nome invalido, tente novamente. Tentativas restantes : " + (3-contador_elementos));
                        nome = teclado.nextLine();
                        if(nome.matches("[A-Za-z]+(\\s+[A-Za-z]+)?")){
                            break;
                        }
                        contador_elementos++;
                        if(contador_elementos == 3){
                            throw new IllegalArgumentException("Numero de tentivas para nome chegaram ao maximo(encerrando...)");
                        }
                        }
                    }
                contador_elementos=0;

                /*
                 * Saber o sobrenome da pessoa
                 * Sobrenome tem que ser apenas alfabetico
                 */
                System.out.print("Sobrenome(Nao pode conter numeros nem cracteres especiais): ");
                sobrenome = teclado.nextLine();

                if(!sobrenome.matches("[A-Za-z]+(?:\\s+[A-Za-z]+)*$")){
                    while(contador_elementos<3){
                        System.out.println("Nome invalido, tente novamente. Tentativas restantes : " + (3-contador_elementos));
                        sobrenome = teclado.nextLine();
                        if(sobrenome.matches("[A-Za-z]+(?:\\s+[A-Za-z]+)*$")){
                            break;
                        }
                        contador_elementos++;
                        if(contador_elementos == 3){
                            throw new IllegalArgumentException("Numero de tentivas para sobrenome chegaram ao maximo(encerrando...)");
                        }
                        }
                    }
                contador_elementos=0;

                /*
                 * Fazer a verificacao completa da data
                 * Dia e ano precisam ser um valores inteiros, ou possiveis de se aplicar um parseInt()
                 * Mes pode receber tanto numeros inteiros quanto strings com o nome do mes
                 */

                boolean dataValida = false;
                while(!dataValida){

                    System.out.print("Dia do nascimento(1-31): ");
                    dia_String = teclado.next();
                    teclado.nextLine();

                    if(!ValidaData.isDia(dia_String)){
                        while(contador_elementos<3){
                            System.out.println("Dia invalido, tente novamente(Dia deve estar entre 1-31). Tentativas restantes: "  + (3-contador_elementos));
                            dia_String = teclado.next();
                            teclado.nextLine();
                            if(ValidaData.isDia(dia_String)){
                                dia = Integer.parseInt(dia_String);
                                break;
                            }
                            contador_elementos++;
                            if(contador_elementos==3){
                                System.out.println("Numero de tentativas maximas para dia alcancado(encerrando...)");
                            }
                        }
                    }else{
                        dia = Integer.parseInt(dia_String);
                    }
                    contador_elementos = 0;

                    System.out.print("Mes de nascimento(1-12 OU janeiro-dezembro): ");
                    mes_String = teclado.next().toUpperCase();
                    teclado.nextLine();

                    if(mes_String.matches("-?\\d+")){{
                        if(Integer.parseInt(mes_String)<13 && Integer.parseInt(mes_String)>0){
                            mes = Integer.parseInt(mes_String);
                        }else{
                                System.out.println("Mes invalido. Insira um valor numerico(1-12) valido para mes(1 tentativa)");
                                mes_String = teclado.next().toUpperCase();
                                teclado.nextLine();
                                if(!mes_String.matches("\\d+") || Integer.parseInt(mes_String)<1 || Integer.parseInt(mes_String)>12){
                                    System.out.println("Nao ha mais tentativas(encerrando...)");
                                    break;
                                }else{
                                    mes = Integer.parseInt(mes_String);
                                }
                            }
                        }
                    }else if(!mes_String.equals("JANEIRO") &&
                    !mes_String.equals("FEVEREIRO") && !mes_String.equals("MARCO") && !mes_String.equals("ABRIL") && !mes_String.equals("MAIO") &&
                    !mes_String.equals("JUNHO") && !mes_String.equals("JULHO") && !mes_String.equals("AGOSTO") && !mes_String.equals("SETEMBRO") &&
                    !mes_String.equals("OUTUBRO") && !mes_String.equals("NOVEMBRO") && !mes_String.equals("DEZEMBRO")){

                        System.out.println("Mes invalido. Insira um valor por extenso(Janeiro-Dezembro) valido para mes. (1 tentaiva)");
                        mes_String = teclado.next().toUpperCase();
                        teclado.nextLine();

                        if(MesesConstantes.verificarMes(mes_String)>12 || MesesConstantes.verificarMes(mes_String)<1){
                            System.out.println("Nao aceitarei mais erros (encerrando...)");
                            break;
                        }else{
                            mes = MesesConstantes.verificarMes(mes_String);
                        }
                    }
                    mes = MesesConstantes.verificarMes(mes_String);

                    System.out.print("Ano de nascimento(0-120 anos de idade): ");
                    ano_String = teclado.next();
                    teclado.nextLine();

                    if(!ano_String.matches("^[0-9]+")){
                        System.out.println("O valor deve ser um inteiro positivo. Tente novamente(1 tentativa)");
                        ano_String = teclado.next();
                        teclado.nextLine();

                        if(ValidaData.isAno(ano_String)){
                                ano = Integer.parseInt(ano_String);
                        }else{
                            System.out.println("Numero de tentativas maximas para ano alcancado(encerrando...)");
                        }
                    }
                    if(!ValidaData.isAno(ano_String)){
                        while(contador_elementos<3){
                            System.out.println("Ano invalido, tente novamente(Ano deve estar entre 0 e 120 anos). Tentativas restantes: "  + (3-contador_elementos));
                            ano_String = teclado.next();
                            teclado.nextLine();

                            if(ValidaData.isAno(ano_String)){
                                ano = Integer.parseInt(ano_String);
                                break;
                            }
                            contador_elementos++;
                            if(contador_elementos==3){
                                System.out.println("Numero de tentativas maximas para ano alcancado(encerrando...)");
                            }
                        }
                    }else{
                        ano = Integer.parseInt(ano_String);
                    }

                    contador_elementos = 0;

                    if(ValidaData.isDataValida(dia, mes, ano)){
                        dataValida = true;
                    }else{
                        System.out.println("A data: " + dia + "/" + mes + "/" + ano + " nao e valida. \nInsira uma data valida");
                    }
                }

                System.out.println("Deseja inserir CPF/Peso/Altura?");
                String resposta = teclado.next().toUpperCase();
                teclado.nextLine();

                /*
                 * Verificar se o usuario quer adicionar informacoes complementares ao cadastro(CPF, Alutra e peso)
                 */

                if(resposta.equals("SIM")){
                    System.out.print("CPF: ");
                    String CPF_STRING = teclado.nextLine();
                    Long CPF_LONG = (long) 0;  // inicializa cpf com um valor absurdo
                    /*
                     * Verificar se o CPF informado bate com o padrao: ^[0-9]{3}[. ]?[0-9]{3}[. ]?[0-9]{3}[- /]?[0-9]{2}$
                     */
                    if(ValidaCPF.isCPF(CPF_STRING)){
                        CPF_LONG = ValidaCPF.toLong(CPF_STRING);
                    }else{
                        while(contador_elementos < 3){
                            System.out.println("CPF invalido, tente novamente. Tentativas restantes: " + (3-contador_elementos));
                            CPF_STRING = teclado.nextLine();

                            if(ValidaCPF.isCPF(CPF_STRING)){
                                CPF_LONG = ValidaCPF.toLong(CPF_STRING);
                                break;
                            }
                            contador_elementos++;
                        }
                    }

                    System.out.print("Peso(5-400kg): ");
                    String peso_String = teclado.next();
                    teclado.nextLine();
                    /*
                     * Verifica se o peso esta entre 5 e 400kg
                     */
                    float peso = 0; //inicializa peso com um valor absurdo

                    while(contador_elementos<3){
                        if(peso_String.matches("^\\d+(\\.?\\d+)?$")){
                            if(Float.parseFloat(peso_String)>=5 && Float.parseFloat(peso_String)<400){
                                peso = Float.parseFloat(peso_String);
                                break;
                            }else{
                                System.out.println("Peso invalido, insira um valor entre 5 e 400kg. Tentativas restantes: " + (3-contador_elementos));
                                peso_String = teclado.next();
                                teclado.nextLine();
                                contador_elementos++;
                            }
                        }else{
                            System.out.println("Peso invalido, insira um valor numerico positivo. Tentativas restantes: " + (3-contador_elementos));
                            peso_String = teclado.next();
                            teclado.nextLine();
                            contador_elementos++;
                        }

                        if(contador_elementos == 3){
                            throw new IllegalArgumentException("Tentativas maximas alcancadas(encerrando...)");
                        }
                    }
                    float altura = 0; // inicializa altura com um valor absurdo
                    System.out.print("Altura(0.5m-2.8m): ");
                    String altura_String = teclado.next();
                    teclado.nextLine();

                    /*
                     * Verifica se a pessoa nao tem menos de 0.5m e nem mais de 2.80m
                     */
                    while(contador_elementos<3){
                        if(altura_String.matches("^\\d+(\\.?\\d+)?$")){
                            if(Float.parseFloat(altura_String)>=0.5 && Float.parseFloat(altura_String)<2.8){
                                altura = Float.parseFloat(altura_String);
                                break;
                            }else{
                                System.out.println("Altura invalida, insira um valor entre 50cm e 2.80m Tentativas restantes: " + (3-contador_elementos));
                                altura_String = teclado.next();
                                teclado.nextLine();
                            }
                        }else{
                            System.out.println("Altura invalida, insira um valor numerico positivo. Tentativas restantes: " + (3-contador_elementos));
                            altura_String = teclado.next();
                            teclado.nextLine();
                        }

                        if(contador_elementos == 3){
                            throw new IllegalArgumentException("Tentativas maximas alcancadas(encerrando...)");
                        }
                        contador_elementos++;

                    }

                    if (genero.equals("HOMEM")) {
                        array2[i] = new Homem(nome, sobrenome, dia, mes, ano, CPF_LONG , peso, altura);
                        System.out.println(genero + " cadastrado!");

                    } else if (genero.equals("MULHER")) {
                        array2[i] = new Mulher(nome, sobrenome, dia, mes, ano, CPF_LONG, peso , altura);
                        System.out.println(genero + " cadastrada!");
                    }
                }else{
                    if (genero.equals("HOMEM")) {
                        array2[i] = new Homem(nome, sobrenome, dia, mes, ano);
                        System.out.println(genero + " cadastrado!");

                    } else if (genero.equals("MULHER")) {
                        array2[i] = new Mulher(nome, sobrenome, dia, mes, ano);
                        System.out.println(genero + " cadastrado!");
                    }
                }
                count++;
            }
            System.out.println("(!!Valores de CPF/Peso/Altura iguais a 0 nao foram inicializados!!)");

            if(array2.length != count){
                Pessoa[] ArrayMenor = Arrays.copyOf(array2 , count);
                for(Pessoa valor: ArrayMenor){
                    System.out.println(valor.toString());
                }

                for(int i = 0; i<ArrayMenor.length; i++){
                    if(ArrayMenor[i] instanceof Homem){
                        HomemCount++;
                    }else{
                        MulherCount++;
                        }
                    }
                System.out.println("-------------------");
                System.out.println("Instancias de Homem: " + HomemCount);
                System.out.println("Instancias de Mulher: " + MulherCount);

            }else{
                for(Pessoa valor: array2){
                    System.out.println(valor.toString());
                }

                for(int i = 0; i<array2.length; i++){
                    if(array2[i] instanceof Homem){
                        HomemCount++;
                    }else{
                        MulherCount++;
                        }
                    }
                System.out.println("----------------------");
                System.out.println("Instancias de Homem: " + HomemCount);
                System.out.println("Instancias de Mulher: " + MulherCount);
                }

        }catch(NumberFormatException nf){
            System.out.println("EROO! Insira um valor valido");
        }catch (IllegalArgumentException i) {
            System.out.println(i);
        }catch(NegativeArraySizeException n){
            System.out.println("ERRO! O tamanho do array nao pode ser negativo.");
        }catch(InputMismatchException in){
            System.out.println("ERRO! Formatação invalida");
        }finally{
            System.out.println("Fim do programa");
        }
    }
}
