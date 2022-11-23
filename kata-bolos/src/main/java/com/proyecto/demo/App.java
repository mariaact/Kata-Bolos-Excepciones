package com.proyecto.demo;


public class App {

    static int contadorXconsecutivas = 0;
    static boolean comprobacionSpares = false;
    static boolean comprobacionStrikes = false;

    public static void main(String[] args) throws LongitudTiradasErroneas {
        App app = new App();
        System.out.println(app.bowling_score("3/ 31 3/ 03 16 12 9/ 7/ 12 XX1"));


    }


    public static int encontrarX(String[] datos, int suma, int i, int longi) {

        if (longi == 1) {
            if (datos[i].charAt(0) == 'X') {
                if (datos[i + 1].length() == 2) {
                    if (datos[(i + 1)].charAt(1) == '/') {
                        suma += 20;
                    } else {
                        suma += ((Character.getNumericValue(datos[(i + 1)].charAt(0)) + Character.getNumericValue(datos[(i + 1)].charAt(1))) + 10);
                    }
                } else if (datos[i + 1].length() == 1 && datos[(i + 1)].charAt(0) == 'X') {
                    contadorXconsecutivas = i + 2;
                    if (datos[(contadorXconsecutivas)].charAt(0) == 'X') {
                        suma += 30;
                        //hay tres x consecuitivas    
                    } else {
                        suma += 20 + Character.getNumericValue(datos[contadorXconsecutivas].charAt(0));
                    }
                } else if (datos[i + 1].length() == 3) {
                    if (datos[(i + 1)].charAt(0) != 'X' && datos[(i + 1)].charAt(1) == '/') {
                        suma += 20;
                    } else {
                        suma += 30;
                    }
                } else if (datos[i + 1].charAt(0) != 'X') {
                    suma += (Character.getNumericValue(datos[(i + 1)].charAt(0)) + 20);
                }
            }
        } else if (longi == 2 && datos[i].charAt(0) == 'X' && datos[i].charAt(1) == 'X') {
            suma = suma + 30;
        } else if (longi == 3 && datos[i].charAt(0) == 'X' && datos[i].charAt(1) == 'X' && datos[i].charAt(2) == 'X') {
            suma = suma + 30;
        }
        return suma;
    }

    public static int encontrarNumeros(String[] datos, int suma, int i) {
        suma += Character.getNumericValue(datos[i].charAt(0)) + Character.getNumericValue(datos[i].charAt(1));
        return suma;
    }

    public static int encontrarBarra(String[] datos, int suma, int i) {
        if (datos[(i + 1)].charAt(0) == 'X') {
            suma += 10 + 10;
        } else {
            suma += 10 + Character.getNumericValue(datos[(i + 1)].charAt(0));
        }
        return suma;
    }

    public static int bowling_score(String frames) throws LongitudTiradasErroneas {

        String[] datos = frames.split(" ");
        int suma = 0;
        int sumax = 0;
        int puntero = 0;

         comprobacionSpares = false;
         comprobacionStrikes = false;

        ControlarSpares(datos);
        ControlarStrikes(datos);
        
     

        if (datos.length == 10 && comprobacionSpares == false && comprobacionStrikes == false) {
            for (int i = 0; i < datos.length; i++) {

                if (datos[i].length() == 1) {
                    if (datos[i].charAt(0) == 'X') {
                        suma = encontrarX(datos, suma, i, 1);
                    }

                } else if (datos[i].length() == 2) {

                    if (datos[i].charAt(0) == 'X' && datos[i].charAt(1) == 'X') {
                        suma = encontrarX(datos, suma, i, 2);
                    } else if (datos[i].charAt(0) == '/' | datos[i].charAt(1) == '/') {
                        suma = encontrarBarra(datos, suma, i);
                    } else {
                        suma = encontrarNumeros(datos, suma, i);
                    }

                } else if (datos[i].length() == 3) {

                    if (datos[i].charAt(0) == 'X' && datos[i].charAt(1) == 'X' && datos[i].charAt(2) == 'X') {
                        //suma = encontrarX(datos, suma, i,3);
                        suma += 30;
                    } else if (datos[i].charAt(0) == 'X' && datos[i].charAt(1) == 'X' && datos[i].charAt(2) != 'X') {
                        suma += 20 + Character.getNumericValue(datos[i].charAt(2));
                    } else if (datos[i].charAt(0) == 'X' && datos[i].charAt(1) != 'X') {
                        //x4/
                        if (datos[i].charAt(0) == 'X' && datos[i].charAt(2) == '/' && datos[i].charAt(1) != 'X') {
                            suma += 20;
                        }
                        //x44
                        if (datos[i].charAt(0) == 'X' && datos[i].charAt(2) != '/') {
                            suma += ((Character.getNumericValue(datos[i].charAt(1)) + Character.getNumericValue(datos[i].charAt(2))) + 10);
                        }
                    } else if (datos[i].charAt(1) == '/' | datos[i].charAt(2) == '/') {
                        //_/_
                        if (datos[i].charAt(1) == '/') {
                            //_/X
                            if (datos[i].charAt(2) == 'X') {
                                suma += 20;

                            } else { //_/_
                                suma += 10 + Character.getNumericValue(datos[i].charAt(2));
                            }
                        } else if (datos[i].charAt(2) == '/') {
                            suma += 10 + Character.getNumericValue(datos[i].charAt(0));
                        }

                        //  suma = suma + (10 + Character.getNumericValue(datos[i].charAt(2)));
                    } else {
                        suma = suma + (Character.getNumericValue(datos[i].charAt(0)) + Character.getNumericValue(datos[i].charAt(1)) + Character.getNumericValue(datos[i].charAt(2)));
                    }
                }
            }
        } else {

            ControlarTiradas(datos.length);
        }

        return suma;
    }

    static void ControlarTiradas(int num) throws LongitudTiradasErroneas {

        try {
            if (num < 10) {
                throw new LongitudTiradasErroneas("Has realizado menos tiradas de las permitidas");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            if (num > 10) {
                throw new LongitudTiradasErroneas("Has realizado mas tiradas de las permitidas");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void ControlarSpares(String[] tirada) throws LongitudTiradasErroneas {

        try {

            for (int i = 0; i < tirada.length; i++) {
                if (tirada[i].charAt(0) == '/') {
                    comprobacionSpares = true;
                    throw new LongitudTiradasErroneas("Esta mal anotado el Spares");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void ControlarStrikes(String[] tirada) throws LongitudTiradasErroneas {

        try {

            for (int i = 0; i < tirada.length; i++) {
                if (tirada[i].length() == 2) {
                    if (tirada[i].charAt(0) == 'X' && tirada[i].charAt(1) == 'X') {
                        throw new LongitudTiradasErroneas("No puedes hacer dos Strikes en una misma jugada");
                    }
                }

            }
        } catch (Exception e) {
            comprobacionStrikes = true;
        }
    }

}

/*public class LongitudTiradasErroneas extends Exception {
    
    LongitudTiradasErroneas(String msg) {
      super(msg);
  }
}*/


