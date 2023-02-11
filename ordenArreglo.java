import sun.font.TrueTypeFont;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class ordenArreglo {
    public static void main(String args[]){

        Scanner entrada = new Scanner(System.in);

        String nombre = "";
        String nit = "";

        boolean valor = false;

        while(!valor){
            System.out.println("Usuario: ");
            String usuario = entrada.nextLine();

            System.out.println("Contrasenia");
            String contra = entrada.nextLine();

            if(usuario.equals("cajero_202007092") && contra.equals("ipc1_202007092")){
                System.out.println("Bienvenido");
                valor = true;
            }else{
                System.out.println("Usuario o contrasenia no validas");
            }
        }

        ArrayList<String> producto = new ArrayList<>();
        ArrayList<Integer> precio = new ArrayList<>();
        ArrayList<String> cupon = new ArrayList();
        ArrayList des = new ArrayList();
        ArrayList clienteProd = new ArrayList();
        ArrayList<Integer> preciosClientes = new ArrayList();



        if(valor){
            boolean bandera = false;
            while (!bandera){
                Scanner sc = new Scanner(System.in);
                System.out.println("1. Agregar nuevos productos.");
                System.out.println("2. Agregar cupones de descuento");
                System.out.println("3. Realizar ventas.");
                System.out.println("4. Realizar reporte");
                System.out.println("5. salir");
                System.out.println("\ningresa la opcion que desear realizar: ");

                int op = entrada.nextInt();

                if(op==1){
                    System.out.println("Agregar Producto");
                    System.out.println("-----------------");

                    entrada.nextLine();

                    System.out.println("Producto: ");
                    String produc = entrada.nextLine();
                    String product = produc;

                    System.out.println(product);


                    System.out.println("Precio: ");
                    int prec = entrada.nextInt();
                    System.out.println(prec);
                    int preci = prec;

                    if(!producto.contains(product)){
                        if(preci>0){
                            producto.add(product);
                            precio.add(preci);
                            System.out.println("Producto ingresado con exito!");
                        }else{
                            System.out.println("precio no valido");

                        }
                    }else{
                        System.out.println("producto ingresado antes");
                        System.out.println(product);
                    }


                }else if(op==2){
                    System.out.println("Agregar cupon de descuento");
                    entrada.nextLine();
                    System.out.println("ingrese el codigo del cupon");
                    String codi = entrada.nextLine();
                    String codigo = codi;
                    System.out.println(codigo);

                    if(codigo.length()==4){
                        if(!cupon.contains(codigo)){
                            System.out.println("ingrese el descuento: ");

                            int descuento = entrada.nextInt();
                            System.out.println(descuento);
                            if(descuento<=0 || descuento >100){
                                System.out.println("Descuento no valido");

                            }else{
                                cupon.add(codigo);
                                des.add(descuento);
                                System.out.println("se realizara el descuento! :D");
                            }
                        }else{
                            System.out.println("este codigo ya fue agregado");
                        }
                    }else{
                        System.out.println("valores del codigo o muy grandes o muy pequenios");
                    }
                }else if(op==3){
                    System.out.println("realizar venta");

                    entrada.nextLine();
                    System.out.println("Ingrese el nombre del cliente: ");
                     nombre = entrada.nextLine();
                    System.out.println("Ingrese el numero de nit/CF");
                    nit = entrada.nextLine();

                    System.out.println("=====================Productos================");
                    for (int i=0;i<producto.size();i++){
                        System.out.println(i+1 + ": " + producto.get(i) + ": Q: "+precio.get(i));
                    }
                    System.out.println("====================Productos=================");

                    boolean salir = false;
                    System.out.println("ingrese el numero del producto y la cantidad");
                    while (!salir){
                        System.out.println("Producto: ");
                        int local = entrada.nextInt();
                        System.out.println("Cantidad: ");
                        int cantidad = entrada.nextInt();
                        local = local-1;
                        System.out.println(local);

                        for(int i=0;i<producto.size();i++){
                            if((i)==local){

                                System.out.println("se agrego el producto");

                                clienteProd.add(producto.get(i));

                                int pre = precio.get(i);
                                int preT = pre * cantidad;

                                preciosClientes.add(preT);
                            }
                        }
                        System.out.println("0. Salir    1. No salir");
                        int sal = entrada.nextInt();
                        if (sal==0){
                            salir=true;
                        }
                    }

                }else if(op==4){
                    int total = 0;
                    System.out.println("emitir Factura");
                    System.out.println("Nombre del cliente: "+nombre);
                    System.out.println("Nit del cliente: "+nit);

                    System.out.println("=========Productos Recibidos==============");
                    System.out.println("Producto          Cantidad");
                    for (int i=0; i<clienteProd.size();i++){
                        System.out.println(clienteProd.get(i)+"      "+preciosClientes.get(i));

                        total = preciosClientes.get(i) +total;

                    }

                    System.out.println("============total============"+total);
                }else if(op==5){
                    System.out.println("hasta pronto! ");
                    System.out.println(producto);
                    System.out.println(precio);
                    System.out.println(des);
                    System.out.println(cupon);
                    bandera = true;
                }else{
                    System.out.println("ingrese una opcion valida");
                }

            }
        }
    }
}
