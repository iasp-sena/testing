/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.ejemplotdd.romanos;

/**
 *
 * @author Ismael
 */
class Romano {

    public String convertir(int numero) {
        String romano = "";
        if (numero == 4) {
            romano = "IV";
        } else if (numero == 9) {
            romano = "IX";
        } else if (numero == 10) {
            romano = "X";
        }
        if (numero >= 1 && numero <= 3) {
            romano = convertirComun("", 0, numero);
        } else if (numero >= 5 && numero <= 8) {
            romano = convertirComun("V", 5, numero);
        }
        return romano;
    }

    private String convertirComun(String romano, int inicio, int numero) {
        for (int i = inicio; i < numero; i++) {
            romano += "I";
        }
        return romano;
    }

}
