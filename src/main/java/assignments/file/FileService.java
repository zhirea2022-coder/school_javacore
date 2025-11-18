package assignments.file;

import java.io.*;

import assignments.colors.v3.ColorException;
import assignments.figures.v3.Rectangle;
import assignments.figures.v3.ColoredRectangle;
import assignments.ttschool.Trainee;
import assignments.ttschool.TrainingException;
import com.google.gson.Gson;


public class FileService {

    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        byte[] arrayToRead = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            arrayToRead = fis.readAllBytes();
        }
        return arrayToRead;
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array)  throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(array, 0, array.length);
        byte[] byteArray = baos.toByteArray();

        int amountOfEvenElements = (byteArray.length + 1) / 2;
        byte[] arrayToRead = new byte[amountOfEvenElements];

        ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
        for (int i = 0; i < amountOfEvenElements; i++) {
            int value = bais.read();
            arrayToRead[i] = (byte) value;
            bais.skip(1);
        }

        return arrayToRead;
    }


    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            bos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        byte[] arrayToRead = null;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            arrayToRead = bis.readAllBytes();
        }
        return arrayToRead;
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException {
        Rectangle rect = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            rect = new Rectangle(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt());
        }
        return rect;
    }

    public static void writeColoredRectangleToBinaryFile(File file, ColoredRectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
            dos.writeUTF(rect.getColor().name());
        }
    }

    public static ColoredRectangle readColoredRectangleFromBinaryFile(File file) throws IOException {
        ColoredRectangle rect = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            rect = new ColoredRectangle(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt(), dis.readUTF());
        } catch (ColorException e) {
            e.printStackTrace();
        }
        return rect;
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (Rectangle rect : rects) {
                dos.writeInt(rect.getTopLeft().getX());
                dos.writeInt(rect.getTopLeft().getY());
                dos.writeInt(rect.getBottomRight().getX());
                dos.writeInt(rect.getBottomRight().getY());
            }
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException {
        final int RECT_SIZE = 16;
        int fileLength = (int) file.length();
        int amountOfRects = fileLength / RECT_SIZE;
        Rectangle[] rectsRead = new Rectangle[amountOfRects];
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            for (int i = 0; i < amountOfRects; i++) {
                long pos = fileLength - (long) (i + 1) * RECT_SIZE;
                raf.seek(pos);

                int xTopLeft = raf.readInt();
                int yTopLeft = raf.readInt();
                int xBottomRight = raf.readInt();
                int yBottomRight = raf.readInt();

                rectsRead[i] = new Rectangle(xTopLeft, yTopLeft, xBottomRight, yBottomRight);
            }
        }

        return rectsRead;
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file))) {
            String rectCoordinates = rect.getTopLeft().getX() + " " +
                    rect.getTopLeft().getY() + " " +
                    rect.getBottomRight().getX() + " " +
                    rect.getBottomRight().getY();
            osw.write(rectCoordinates);
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException {
        Rectangle rect = null;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] rectCoordinates = br.readLine().split(" ");
            rect = new Rectangle(Integer.parseInt(rectCoordinates[0]),
                    Integer.parseInt(rectCoordinates[1]),
                    Integer.parseInt(rectCoordinates[2]),
                    Integer.parseInt(rectCoordinates[3]));
        }
        return rect;
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(Integer.toString(rect.getTopLeft().getX()));
            bw.newLine();
            bw.write(Integer.toString(rect.getTopLeft().getY()));
            bw.newLine();
            bw.write(Integer.toString(rect.getBottomRight().getX()));
            bw.newLine();
            bw.write(Integer.toString(rect.getBottomRight().getY()));
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException {
        Rectangle rect = null;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String xTopLeft = br.readLine();
            String yTopLeft = br.readLine();
            String xBottomRight = br.readLine();
            String yBottomRight = br.readLine();
            rect = new Rectangle(Integer.parseInt(xTopLeft),
                    Integer.parseInt(yTopLeft),
                    Integer.parseInt(xBottomRight),
                    Integer.parseInt(yBottomRight));
        }
        return rect;
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8")) {
            String traineeInOneLine = trainee.getFirstName() + " " +
                    trainee.getLastName() + " " +
                    trainee.getRating();
            osw.write(traineeInOneLine);
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException {
        Trainee trainee = null;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String[] traineeInOneLine = br.readLine().split(" ");
            trainee = new Trainee(traineeInOneLine[0],
                    traineeInOneLine[1],
                    Integer.parseInt(traineeInOneLine[2]));
        } catch (TrainingException e) {
            e.printStackTrace();
        }
        return trainee;
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bw.write(trainee.getFirstName());
            bw.newLine();
            bw.write(trainee.getLastName());
            bw.newLine();
            bw.write(Integer.toString(trainee.getRating()));
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException {
        Trainee trainee = null;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String firstName = br.readLine();
            String lastName = br.readLine();
            int rating = Integer.parseInt(br.readLine());
            trainee = new Trainee(firstName, lastName, rating);
        } catch (TrainingException e) {
            e.printStackTrace();
        }
        return trainee;
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(trainee);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException {
        Trainee trainee = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            trainee = (Trainee) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return trainee;
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(serializeTraineeToJsonString(trainee));
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        Trainee trainee = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            trainee = gson.fromJson(br, Trainee.class);
        }
        return trainee;
    }
}