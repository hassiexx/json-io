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

import org.json.JSONArray;
import org.json.JSONObject;
import uk.co.hassieswift621.libraries.jsonio.exceptions.JsonIOException;

import java.io.*;

/**
 * Created by Hassie on Sunday, 06 May, 2018 - 20:54.
 */
public class JsonIO {

    /**
     * Converts an input stream to an UTF-8 encoded JSON object.
     *
     * @param inputStream The input stream.
     * @return A UTF-8 encoded JSON object.
     * @throws JsonIOException If the conversion failed.
     */
    public static JSONObject toJson(InputStream inputStream) throws JsonIOException {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            // Create buffer.
            byte[] buffer = new byte[1024];

            // Convert input stream to byte array output stream.
            int length = inputStream.read(buffer);
            while (length != -1) {
                outputStream.write(buffer, 0, length);
                length = inputStream.read(buffer);
            }

            // Convert output stream to JSON.
            return new JSONObject(outputStream.toString("UTF-8"));

        } catch (IOException e) {
            throw new JsonIOException("Failed to convert input stream to JSON", e);
        }
    }

    /**
     * Converts a file to a UTF-8 encoded JSON object.
     *
     * @param file The file to convert.
     * @return A UTF-8 encoded JSON object.
     * @throws JsonIOException If the conversion failed.
     */
    public static JSONObject toJson(File file) throws JsonIOException {

        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            return toJson(fileInputStream);

        } catch (IOException e) {
            throw new JsonIOException("Failed to convert file to JSON", e);
        }
    }

    /**
     * Converts a JSON string to a UTF-8 encoded JSON object.
     *
     * @param string The JSON as a string.
     * @return A UTF-8 encoded JSON object.
     * @throws JsonIOException If the conversion failed.
     */
    public static JSONObject toJson(String string) throws JsonIOException {

        // Get raw JSON.
        byte[] rawJson = string.getBytes();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            // Convert bytes to output stream.
            outputStream.write(rawJson);

            // Convert output stream to JSON.
            return new JSONObject(outputStream.toString("UTF-8"));

        } catch (IOException e) {
            throw new JsonIOException("Failed to convert string to JSON", e);
        }
    }

    /**
     * Outputs a JSON object to a UTF-8 encoded file.
     *
     * @param json The JSON object to output.
     * @param file The file to create.
     * @throws JsonIOException If the output failed.
     */
    public static void toFile(JSONObject json, File file) throws JsonIOException {

        toFile(json, file, false);
    }

    /**
     * Outputs a JSON object to a UTF-8 encoded file.
     *
     * @param json   The JSON object to output.
     * @param file   The file to create or to append to.
     * @param append Whether to append the JSON contents to a file.
     * @throws JsonIOException If the output failed.
     */
    public static void toFile(JSONObject json, File file, boolean append) throws JsonIOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append)) {

            // Get raw JSON.
            byte[] rawJson = json.toString().getBytes("UTF-8");

            // Write the raw JSON to file.
            fileOutputStream.write(rawJson);

        } catch (IOException e) {
            throw new JsonIOException("Failed to convert JSON to file", e);
        }
    }

    /**
     * Converts a JSON object to a UTF-8 encoded string.
     *
     * @param json The JSON object to convert.
     * @return A UTF-8 encoded string.
     * @throws JsonIOException If the conversion failed.
     */
    public static String toString(JSONObject json) throws JsonIOException {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            // Get raw JSON.
            byte[] rawJson = json.toString().getBytes();

            outputStream.write(rawJson);

            // Convert output stream to string.
            return outputStream.toString("UTF-8");

        } catch (IOException e) {
            throw new JsonIOException("Failed to convert JSON to string", e);
        }
    }

    /**
     * Converts an input stream to an UTF-8 encoded JSON array object.
     *
     * @param inputStream The input stream.
     * @return A UTF-8 encoded JSON array object.
     * @throws JsonIOException If the conversion failed.
     */
    public static JSONArray toJsonArray(InputStream inputStream) throws JsonIOException {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            // Create buffer.
            byte[] buffer = new byte[1024];

            // Convert input stream to byte array output stream.
            int length = inputStream.read(buffer);
            while (length != -1) {
                outputStream.write(buffer, 0, length);
                length = inputStream.read(buffer);
            }

            // Convert output stream to JSON.
            return new JSONArray(outputStream.toString("UTF-8"));

        } catch (IOException e) {
            throw new JsonIOException("Failed to convert input stream to JSON array", e);
        }
    }

    /**
     * Converts a file to a UTF-8 encoded JSON array object.
     *
     * @param file The file to convert.
     * @return A UTF-8 encoded JSON array object.
     * @throws JsonIOException If the conversion failed.
     */
    public static JSONArray toJsonArray(File file) throws JsonIOException {

        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            return toJsonArray(fileInputStream);

        } catch (IOException e) {
            throw new JsonIOException("Failed to convert file to JSON array", e);
        }
    }

    /**
     * Converts a JSON string to a UTF-8 encoded JSON array object.
     *
     * @param string The JSON as a string.
     * @return A UTF-8 encoded JSON array object.
     * @throws JsonIOException If the conversion failed.
     */
    public static JSONArray toJsonArray(String string) throws JsonIOException {

        // Get raw JSON.
        byte[] rawJson = string.getBytes();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            // Convert bytes to output stream.
            outputStream.write(rawJson);

            // Convert output stream to JSON.
            return new JSONArray(outputStream.toString("UTF-8"));

        } catch (IOException e) {
            throw new JsonIOException("Failed to convert string to JSON array", e);
        }
    }

    /**
     * Outputs a JSON array object to a UTF-8 encoded file.
     *
     * @param json The JSON array object to output.
     * @param file The file to create.
     * @throws JsonIOException If the output failed.
     */
    public static void toFile(JSONArray json, File file) throws JsonIOException {

        toFile(json, file, false);
    }

    /**
     * Outputs a JSON array object to a UTF-8 encoded file.
     *
     * @param json   The JSON array object to output.
     * @param file   The file to create or to append to.
     * @param append Whether to append the JSON array contents to a file.
     * @throws JsonIOException If the output failed.
     */
    public static void toFile(JSONArray json, File file, boolean append) throws JsonIOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append)) {

            // Get raw JSON.
            byte[] rawJson = json.toString().getBytes("UTF-8");

            // Write the raw JSON to file.
            fileOutputStream.write(rawJson);

        } catch (IOException e) {
            throw new JsonIOException("Failed to convert JSON array to file", e);
        }
    }

    /**
     * Converts a JSON array object to a UTF-8 encoded string.
     *
     * @param json The JSON array object to convert.
     * @return A UTF-8 encoded string.
     */
    public static String toString(JSONArray json) throws JsonIOException {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            // Get raw JSON.
            byte[] rawJson = json.toString().getBytes();

            outputStream.write(rawJson);

            // Convert output stream to string.
            return outputStream.toString("UTF-8");

        } catch (IOException e) {
            throw new JsonIOException("Failed to convert JSON array to string", e);
        }
    }

    /**
     * Converts an input stream to an UTF-8 encoded JSON object.
     *
     * @param inputStream The input stream.
     * @return A UTF-8 encoded JSON object.
     * @throws IOException If the conversion failed.
     */
    @Deprecated
    public static JSONObject toJSON(InputStream inputStream) throws IOException {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            // Create buffer.
            byte[] buffer = new byte[1024];

            // Convert input stream to byte array output stream.
            int length = inputStream.read(buffer);
            while (length != -1) {
                outputStream.write(buffer, 0, length);
                length = inputStream.read(buffer);
            }

            // Convert output stream to JSON.
            return new JSONObject(outputStream.toString("UTF-8"));
        }
    }

    /**
     * Converts a file to a UTF-8 encoded JSON object.
     *
     * @param file The file to convert.
     * @return A UTF-8 encoded JSON object.
     * @throws IOException If the conversion failed.
     */
    @Deprecated
    public static JSONObject toJSON(File file) throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            return toJSON(fileInputStream);
        }
    }

    /**
     * Converts a JSON string to a UTF-8 encoded JSON object.
     *
     * @param string The JSON as a string.
     * @return A UTF-8 encoded JSON object.
     * @throws IOException If the conversion failed.
     */
    @Deprecated
    public static JSONObject toJSON(String string) throws IOException {

        // Get raw JSON.
        byte[] rawJSON = string.getBytes();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            // Convert bytes to output stream.
            outputStream.write(rawJSON);

            // Convert output stream to JSON.
            return new JSONObject(outputStream.toString("UTF-8"));
        }
    }

}