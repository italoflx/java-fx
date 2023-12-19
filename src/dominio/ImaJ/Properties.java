package dominio.ImaJ;

/**
 * Esta classe representa uma propriedade de um determinado objeto.
 * 
 * @author Nome do Autor
 * @version 1.0
 */
public class Properties {
    /**
     * Área total da propriedade
     */
    public int area;
    /**
     * Array contendo o tamanho da caixa delimitadora da propriedade
     */
    public int[] boundingBox;
    /**
     * Matriz contendo a imagem da propriedade
     */
    public boolean[][] image;
    /**
     * Valor contendo o nivel medio de vermelho do objeto
     */
    public int nivelMedioVermelho;
    /**
     * Valor contendo o nivel medio de verde do objeto
     */
    public int nivelMedioVerde;
/**
     * Valor contendo o nivel medio de azul do objeto
     */
    public int nivelMedioAzul;

    public Properties() {
        boundingBox = new int[4];
    }

    public int[] calculaMediaCanais(int[][][] image) {
        int mediaVermelho = 0;
        int mediaVerde = 0;
        int mediaAzul = 0;
        int totalPixels = 0;
    
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                // Considerar apenas pixels que não fazem parte do fundo
                if (image[x][y][0] != 0 || image[x][y][1] != 0 || image[x][y][2] != 0) {
                    mediaVermelho += image[x][y][0];
                    mediaVerde += image[x][y][1];
                    mediaAzul += image[x][y][2];
                    totalPixels++;
                }
            }
        }
    
        if (totalPixels > 0) {
            mediaVermelho /= totalPixels;
            mediaVerde /= totalPixels;
            mediaAzul /= totalPixels;
        }
    
        int[] resultado = {mediaVermelho, mediaVerde, mediaAzul};
        return resultado;
    }
}