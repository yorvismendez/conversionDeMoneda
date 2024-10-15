import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        boolean loop = true;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://open.er-api.com/v6/latest/USD"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response = " + response.body());

        Gson gson = new Gson();

        Response responseuri = gson.fromJson(response.body(), Response.class);

        if (responseuri.getResultado().equals("success")){
            while (loop){
                String menu = """
                    *****************************************
                    Bienvenido al conversor de moneda
                    
                    
                    1)Dolar =>> Peso argentino
                    2)Peso argentino =>> Dolar
                    3)Dolar =>> Real brasileño
                    4)Real brasileño =>> Dolar
                    5)Dolar =>> Peso colombiano
                    6)Peso colombiano =>> Dolar
                    7) Salir
                    
                    Elija una opcion valida:
                    *****************************************""";
                System.out.println(menu);
                Scanner keywoard = new Scanner(System.in);

                String option = keywoard.nextLine();

                switch (option){

                    case "1":
                        System.out.println("Ingresa el valor que desea convertir");
                        String cantidad = keywoard.nextLine();

                        double cantidadn = Double.parseDouble(cantidad);
                        double result = cantidadn * responseuri.getRates().getParg();

                        System.out.println("El valor " + cantidadn + " [USD] corresponde al valor final de =>>> " + result + "[ARG]");
                        break;
                    case "2":
                        System.out.println("Ingresa el valor que desea convertir");
                        cantidad = keywoard.nextLine();

                        cantidadn = Double.parseDouble(cantidad);
                        result = cantidadn / responseuri.getRates().getParg();

                        System.out.println("El valor " + cantidadn + " [ARG] corresponde al valor final de =>>> " + result + "[USD]");
                        break;
                    case "3":
                        System.out.println("Ingresa el valor que desea convertir");
                        cantidad = keywoard.nextLine();

                        cantidadn = Double.parseDouble(cantidad);
                        result = cantidadn * responseuri.getRates().getRbr();

                        System.out.println("El valor " + cantidadn + " [USD] corresponde al valor final de =>>> " + result + "[BRL]");
                        break;
                    case "4":
                        System.out.println("Ingresa el valor que desea convertir");
                        cantidad = keywoard.nextLine();

                        cantidadn = Double.parseDouble(cantidad);
                        result = cantidadn / responseuri.getRates().getRbr();

                        System.out.println("El valor " + cantidadn + " [BRL] corresponde al valor final de =>>> " + result + "[USD]");
                        break;
                    case "5":
                        System.out.println("Ingresa el valor que desea convertir");
                        cantidad = keywoard.nextLine();

                        cantidadn = Double.parseDouble(cantidad);
                        result = cantidadn * responseuri.getRates().getPcol();

                        System.out.println("El valor " + cantidadn + " [USD] corresponde al valor final de =>>> " + result + "[COP]");
                        break;
                    case "6":
                        System.out.println("Ingresa el valor que desea convertir");
                        cantidad = keywoard.nextLine();

                        cantidadn = Double.parseDouble(cantidad);
                        result = cantidadn / responseuri.getRates().getPcol();

                        System.out.println("El valor " + cantidadn + " [COP] corresponde al valor final de =>>> " + result + "[USD]");
                        break;
                    case "7":
                        loop = false;
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }

            }

        }

    }

}