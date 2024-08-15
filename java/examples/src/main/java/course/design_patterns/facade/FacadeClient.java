package course.design_patterns.facade;

/**
 *
 * Clase que utiliza la fachada.
 *
 * @author Pablo Hincapie
 */
class FacadeClient {

    public static void main(String[] args) {

        /*
        * La flexibilidad de la fachada se entiende mejor cuando se tiene código que la utiliza.
        *
        * En este caso, solo se necesitan 2 líneas para consumir un método que tiene
        * más de 10 líneas de código, usa 4 clases, maneja excepciones, y emplea diversos métodos de java.io.
        * */

        FileManager manager = new FileManager();
        int count = manager.countCharacters("test.txt");
        System.out.println("Número de caracteres: " + count);

    }

}
