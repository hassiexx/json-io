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

package uk.co.hassieswift621.libraries.jsonio.sample;

import org.json.JSONObject;
import uk.co.hassieswift621.libraries.jsonio.JsonIO;

import java.io.File;
import java.io.IOException;

/**
 * Created by Hassie on Monday, 07 May, 2018 - 12:07.
 */
public class JsonIOSample {

    public static void main(String[] args) {

        // Example 1 - string to UTF-8 JSON object.
        example1();

        // Example 2 - file to UTF-8 JSON object.
        example2();

        // Example 3 - JSON object to UTF-8 file.
        example3();

        // Example 4 - JSON object to UTF-8 string.
        example4();
    }

    private static void example1() {

        String jsonString = "{\"text\":\"Ø©®Ą\"}";

        try {
            // Convert string to JSON object.
            JSONObject jsonObject = JsonIO.toJSON(jsonString);

            // Expected output: Ø©®Ą
            System.out.println("Example 1: " + jsonObject.getString("text"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void example2() {

        try {
            JSONObject jsonObject = JsonIO.toJSON(new File("sample_json.json"));

            // Expected output: String with special chars: Ø©®Ą
            System.out.println("Example 2: " + jsonObject.getString("text"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void example3() {

        try {
            // Create a JSON object.
            JSONObject jsonObject = JsonIO.toJSON(new File("sample_json.json"));

            // Output the json object.
            // Expected output: Same as the sample_json.json file.
            JsonIO.toFile(jsonObject, new File("output.json"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void example4() {

        try {
            // Create a JSON object.
            JSONObject jsonObject = JsonIO.toJSON(new File("sample_json.json"));

            // Convert JSON object to string.
            System.out.println("Example 4: " + JsonIO.toString(jsonObject));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
