package course.design_patterns.facade;

import java.io.*;
import java.net.URL;

/**
 *
 * Fachada (facade).
 *
 * Esta clase aplica el patrón de Facade (fachada) ya que esconde toda la complejidad detrás de utilizar
 * el api de IO (entrada y salida de datos).
 *
 * Para el desarrollador que use la clase, es tan transparente como pasar la ruta del archivo al método
 * countCharacters, y listo. Todas las clases, llamados al API de Java y validaciones quedan ocultas detrás de la
 * fachada.
 *
 * Este patrón se utiliza para facilitar el uso de subsistemas, librerías y frameworks.
 *
 * @author Pablo Hincapie
 */

class FileManager {

    /**
     * countCharacters hace parte de la fachada que facilita la operación.
     * */
    public int countCharacters(String filePath) {

        URL resource = getClass().getClassLoader().getResource(filePath);
        if(resource == null) {
            return -1;
        }

        File file = new File(resource.getFile());

        int count = 0;

        try(FileReader fileReader = new FileReader(file)) {

            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String line = bufferedReader.readLine();
                while (line != null) {
                    count += line.length();
                    line = bufferedReader.readLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;

    }

}
