package com.proyecto.demo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void bowlingScoreTest() throws LongitudTiradasErroneas{
        assertEquals(20, App.bowling_score("11 11 11 11 11 11 11 11 11 11"));
    }

    @Test
    public void bowlingScoreTest2() throws LongitudTiradasErroneas{
        assertEquals(300, App.bowling_score("X X X X X X X X X XXX"));
    }


    @Test
    public void bowlingScoreTest4() throws LongitudTiradasErroneas{
        assertEquals(150, App.bowling_score("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5"));
    }
     
    @Test
    public void bowlingScoreTest5() throws LongitudTiradasErroneas{
        assertEquals(90, App.bowling_score("90 90 90 90 90 90 90 90 90 90"));
    }

    @Test
    public void bowlingScoreTest6() throws LongitudTiradasErroneas{
        assertEquals(127, App.bowling_score("43 5/ 36 42 4/ X 62 4/ 72 X5/"));
    }

    @Test
    public void bowlingScoreTest7() throws LongitudTiradasErroneas{
        assertEquals(90, App.bowling_score("90 90 90 90 90 90 90 90 90 90"));
    }
    
    @Test
    public void bowlingScoreTest8() throws LongitudTiradasErroneas{
        assertEquals(106, App.bowling_score("45 45 23 43 54 X X 54 34 61"));
    }

    @Test
    public void bowlingScoreTest9() throws LongitudTiradasErroneas{
        assertEquals(142, App.bowling_score("42 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/6"));
    }

    @Test
    public void bowlingScoreTest10() throws LongitudTiradasErroneas{
        assertEquals(218, App.bowling_score("33 X X X X X X X 71 45"));
    }

    @Test
    public void bowlingScoreTest11() throws LongitudTiradasErroneas{
        assertEquals(150, App.bowling_score("5/ 4/ 3/ 2/ 1/ 0/ X 9/ 4/ 8/8"));
    }

    @Test
    public void bowlingScoreTest12() throws LongitudTiradasErroneas{
        assertEquals(20, App.bowling_score("00 00 00 00 00 00 00 00 00 0/X"));
    }

    @Test
    public void bowlingScoreTest13() throws LongitudTiradasErroneas{
        assertEquals(40, App.bowling_score("00 00 00 00 00 00 00 00 X 1/X"));
    }

    @Test
    public void bowlingScoreTest14() throws LongitudTiradasErroneas{
        assertEquals(92, App.bowling_score("3/ 31 3/ 03 16 12 9/ 7/ 12 XX1"));
    }

    @Test
    public void ControlarSparesErrorPosicionPrimeraTiradaComprobarPuntos(){
        try {
            assertEquals(0, App.bowling_score("3/ 31 3/ /3 16 12 9/ 7/ 12 XX1"));           
        } catch (LongitudTiradasErroneas e) {
        }
    }

    @Test
    public void ControlarSparesErrorPosicionPrimeraTiradaComprobarMensaje(){
        try {
            App.bowling_score("3/ 31 3/ /3 16 12 9/ 7/ 12 XX1");           
        } catch (LongitudTiradasErroneas e) {
            System.out.println( e.getMessage());
            assertEquals(e.getMessage(), "Esta mal anotado el Spares");           

            
        }
    }

    @Test
    public void ControlarStrikesErrorDosTiradasSeguidasComprobarPuntos(){
        try {
            assertEquals(0, App.bowling_score("3/ 31 3/ XX 16 12 9/ 7/ 12 XX1"));           
        } catch (LongitudTiradasErroneas e) {
        }
    }

    @Test
    public void ControlarStrikesErrorDosTiradasSeguidasComprobarMensaje(){
        try {
            App.bowling_score("3/ 31 3/ XX 16 12 9/ 7/ 12 XX1");           
        } catch (LongitudTiradasErroneas e) {
            assertEquals(e.getMessage(), "No puedes hacer dos Strikes en una misma jugada");           

            
        }
    }

    @Test
    public void ControlarTitadasErrorMayorQue10ComprobarPuntos(){
        try {
            assertEquals(0, App.bowling_score("3/ 31 3/ XX 16 12 9/ 7/ 12 XX1 63"));           
        } catch (LongitudTiradasErroneas e) {
        }
    }

    @Test
    public void ControlarTitadasErrorMayorQue10ComprobarTexto(){
        try {
            App.bowling_score("3/ 31 3/ XX 16 12 9/ 7/ 12 XX1 63");           
        } catch (LongitudTiradasErroneas e) {
            assertEquals(e.getMessage(), "Has realizado mas tiradas de las permitidas");           
        }
    }

    @Test
    public void ControlarTitadasErrorMenorQue10ComprobarPuntos(){
        try {
            assertEquals(0, App.bowling_score("3/ 31 3/ XX 16 12 9/ 7/ 12"));           
        } catch (LongitudTiradasErroneas e) {
        }
    }

    @Test
    public void ControlarTitadasErrorMenorQue10ComprobarTexto(){
        try {
            App.bowling_score("3/ 31 3/ XX 16 12 9/ 7/ 12");           
        } catch (LongitudTiradasErroneas e) {
            assertEquals(e.getMessage(), "Has realizado menos tiradas de las permitidas");           
        }
    }

}

