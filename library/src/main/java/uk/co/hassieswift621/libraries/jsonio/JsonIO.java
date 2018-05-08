/*
 * Copyright ©2018 HassieSwift621.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.hassieswift621.libraries.jsonio;

import org.json.JSONObject;

import java.io.*;

/**
 * Created by Hassie on Sunday, 06 May, 2018 - 20:54.
 */
public class JsonIO {

    /**
     * Converts an input stream to an UTF-8 encoded JSON object.
     * @param inputStream The input stream.
     * @return A UTF-8 encoded JSON object.
     * @throws IOException If the conversion failed.
     */
    public static JSONObject toJSON(InputStream inputStream) throws IOException {

        // Create output stream.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];

        // Read input stream.
        int length = inputStream.read(buffer);
        while (length != -1) {
            outputStream.write(buffer, 0, length);
            length = inputStream.read(buffer);
        }

        // Convert output stream to JSON.
        JSONObject json = new JSONObject(outputStream.toString("UTF-8"));

        // Close the output stream.
        outputStream.close();

        return json;
    }

    /**
     * Converts a file to a UTF-8 encoded JSON object.
     * @param file The file to convert.
     * @return A UTF-8 encoded JSON object.
     * @throws IOException If the conversion failed.
     */
    public static JSONObject toJSON(File file) throws IOException {

        // Create file input stream.
        FileInputStream fileInputStream = new FileInputStream(file);

        // Convert input stream to JSON.
        JSONObject json = toJSON(fileInputStream);

        // Close the input stream.
        fileInputStream.close();

        return json;
    }

    /**
     * Converts a JSON string to a UTF-8 encoded JSON object.
     * @param string The JSON as a string.
     * @return A UTF-8 encoded JSON object.
     * @throws IOException If the conversion failed.
     */
    public static JSONObject toJSON(String string) throws IOException {

        // Get raw JSON.
        byte[] rawJSON = string.getBytes();

        // Convert bytes to output stream.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(rawJSON);

        // Convert output stream to JSON.
        JSONObject json = new JSONObject(outputStream.toString("UTF-8"));

        // Close the output stream.
        outputStream.close();

        return json;
    }

    /**
     * Outputs a JSON object to a UTF-8 encoded file.
     * @param json The JSON object to output.
     * @param file The file to create.
     * @throws IOException If the output failed.
     */
    public static void toFile(JSONObject json, File file) throws IOException {

        toFile(json, file, false);
    }

    /**
     * Outputs a JSON object to a UTF-8 encoded file.
     * @param json The JSON object to output.
     * @param file The file to create or to append to.
     * @param append Whether to append the JSON contents to a file.
     * @throws IOException If the output failed.
     */
    public static void toFile(JSONObject json, File file, boolean append) throws IOException {

        // Get raw JSON.
        byte[] rawJSON = json.toString().getBytes("UTF-8");

        // Create output stream.
        FileOutputStream fileOutputStream = new FileOutputStream(file, append);

        // Write the raw JSON.
        fileOutputStream.write(rawJSON);
    }

    /**
     * Converts a JSON object to a UTF-8 encoded string.
     * @param json The JSON object to convert.
     * @return A UTF-8 encoded string.
     */
    public static String toString(JSONObject json) throws IOException {

        // Get raw JSON.
        byte[] rawJSON = json.toString().getBytes();

        // Convert bytes to output stream.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(rawJSON);

        // Convert output stream to string.
        String jsonString = outputStream.toString("UTF-8");

        // Close output stream.
        outputStream.close();

        return jsonString;
    }

}
