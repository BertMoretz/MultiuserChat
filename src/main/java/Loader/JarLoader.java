package Loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarLoader extends ClassLoader {

    private String path;

    public JarLoader(String path) {
        this.path = path;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            JarFile jarLib = null;
            String[] libFiles = new String[0];

            /* directory was specified */
            File dir = new File(path);
            libFiles = dir.list();


            if (libFiles != null) {
                for (String filepath : libFiles) {
                    if (filepath.equals(name + ".jar")) {
                        jarLib = new JarFile(path + filepath);
                        break;
                    }
                }
            } else {
                throw new IOException();
            }

            if (jarLib != null) {
                JarEntry jarEntry = jarLib.getJarEntry(
                        name.substring(0,1).toUpperCase() + name.substring(1) + ".class");

                InputStream libInputStream = jarLib.getInputStream(jarEntry);

                byte[] classBytes = new byte[(int) jarEntry.getSize()];
                if (libInputStream.read(classBytes) != classBytes.length) {
                    throw new IOException("Could not completely read the file " + path);
                }

                System.out.println("\tLoading class from " + jarLib.getName());

                return defineClass(name.substring(0,1).toUpperCase() + name.substring(1), classBytes, 0, classBytes.length);
            }

            throw new IOException();

        } catch (FileNotFoundException e) {
            System.out.printf("Jar File %s is not found\n", path);
            throw new ClassNotFoundException(e.getMessage(), e);
        } catch (IOException e) {
            System.out.printf("An error occurred while reading the lib path %s\n", path);
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }
}
