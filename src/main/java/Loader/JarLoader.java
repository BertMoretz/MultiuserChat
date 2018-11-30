package Loader;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarLoader extends ClassLoader {

    private static final Logger log = Logger.getLogger(JarLoader.class);
    private String path;

    public JarLoader(String path) {
        this.path = path;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            JarFile jarLib = null;

            /* directory was specified */
            File dir = new File(path);
            String[] libFiles = dir.list();


            if (libFiles != null) {
                for (String filepath : libFiles) {
                    if (filepath.equals(name + ".jar")) {
                        jarLib = new JarFile(path + filepath);
                        break;
                    }
                }
            } else {
                log.error("There are no files in this path");
                throw new IOException();
            }

            if (jarLib != null) {
                JarEntry jarEntry = jarLib.getJarEntry(
                        name.substring(0,1).toUpperCase() + name.substring(1) + ".class");

                InputStream libInputStream = jarLib.getInputStream(jarEntry);

                byte[] classBytes = new byte[(int) jarEntry.getSize()];
                if (libInputStream.read(classBytes) != classBytes.length) {
                    log.error("Could not completely read the file " + path);
                }

                log.info("\tLoading class from " + jarLib.getName());

                return defineClass(name.substring(0,1).toUpperCase() + name.substring(1), classBytes, 0, classBytes.length);
            }

            throw new IOException();

        } catch (FileNotFoundException e) {
            log.error("Jar File " + path + " is not found\n");
            throw new ClassNotFoundException(e.getMessage(), e);
        } catch (IOException e) {
            log.error("An error occurred while reading the path " + path + "\n");
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }
}
