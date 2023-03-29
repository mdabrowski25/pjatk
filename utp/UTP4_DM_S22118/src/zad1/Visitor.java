package zad1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Visitor implements FileVisitor<Path> {
    private BufferedWriter writer;

    public Visitor(Path outPath) throws IOException {
        System.out.println(outPath);
        writer = new BufferedWriter(
                new OutputStreamWriter(
                        Files.newOutputStream(outPath.toFile().toPath()),
                        StandardCharsets.UTF_8
                )
        );
    }

    public void preDestroy() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(Files.newInputStream(Paths.get(file.toString())), "cp1250")
        );

        String line;

        while ((line = in.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }

        in.close();

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
