package steps.api;

import hooks.ApiHooks;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

@ExtendWith({ApiHooks.class})
public class test {

    public void compareSpecies(String mortySpecies, String species) {
        if (mortySpecies.equals(species)) {
            System.out.println("Расы совпадают");
        } else {
            System.out.println("Расы не совпадают");
        }
    }

    public void compareLocation(String mortyLocation, String location) {
        if (mortyLocation.equals(location)) {
            System.out.println("Локации совпадают");
        } else {
            System.out.println("Локации не совпадают");
        }
    }

    @Tag("1api")
    @Test
    @DisplayName("Задание 1")
    public void morty() {

        Response response1 = given()
                .baseUri("https://rickandmortyapi.com/")
                .contentType(ContentType.JSON)
                .when()
                .get("/api/character/2")
                .then()
                .extract().response();

        String infoMorty = response1.getBody().asString();
        JSONObject jsonMorty = new JSONObject(infoMorty);
        JSONArray episodesWithMorty = jsonMorty.getJSONArray("episode");
        int episodesCount = episodesWithMorty.length();
        String lastEpisode = episodesWithMorty.getString(episodesCount - 1);
        String mortySpecies = jsonMorty.getString("species");
        String mortyLocation = jsonMorty.getJSONObject("location").getString("name");
        System.out.println("Раса Морти: " + mortySpecies);
        System.out.println("Локация Морти: " + mortyLocation);
        System.out.println("Последний эпизод с Морти: " + lastEpisode);


        Response response2 = given()
                .baseUri("https://rickandmortyapi.com/")
                .contentType(ContentType.JSON)
                .when()
                .get(lastEpisode)
                .then()
                .extract().response();

        String lastMortyEpisode = response2.getBody().asString();
        JSONObject jsonLastEpisode = new JSONObject(lastMortyEpisode);
        JSONArray charactersInLastEpisode = jsonLastEpisode.getJSONArray("characters");
        int charactersCount = charactersInLastEpisode.length();
        String lastCharacter = charactersInLastEpisode.getString(charactersCount - 1);
        System.out.println("Последний персонаж в эпизоде: " + lastCharacter);


        Response response3 = given()
                .baseUri("https://rickandmortyapi.com/")
                .contentType(ContentType.JSON)
                .when()
                .get(lastCharacter)
                .then()
                .extract().response();

        String desiredCharacter = response3.getBody().asString();
        JSONObject jsonCharacter = new JSONObject(desiredCharacter);
        String species = jsonCharacter.getString("species");
        String location = jsonCharacter.getJSONObject("location").getString("name");
        System.out.println("Его раса — " + species + ", локация — " + location);

        compareSpecies(mortySpecies, species);
        compareLocation(mortyLocation, location);
    }

    @Tag("2api")
    @Test
    @DisplayName("Задание 2")
    public void test2() throws IOException {
        JSONObject requestBody = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/test2.json"))));
        requestBody.put("name", "Tomato");
        requestBody.put("job", "Eat maket");

        Response response3 = given()
                .baseUri("https://reqres.in/")
                .contentType("application/json;charset=UTF-8")
                .log().all()
                .when()
                .body(requestBody.toString())
                .post("/api/users")
                .then()
                .statusCode(201)
                .log().all()
                .extract().response();

        String userTomato = response3.getBody().asString();
        JSONObject json = new JSONObject(userTomato);
        Assertions.assertEquals(json.getString("name"), "Tomato");
        Assertions.assertEquals(json.getString("job"), "Eat maket");
    }

}





