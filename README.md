# SkullCreator
SkullCreator is a library designed to make the creation of player skulls as easy as possible.

Javadocs are available at https://skullcreator.dbassett.dev, otherwise you can keep looking here!

I spent quite a bit of time researching how player skulls behaved, and figuring out
a single solution that works for all versions of Minecraft,
so leaving a :star: would mean a lot!

**Supported versions: 1.12.2 and newer.**

## Usage
Using the SkullCreator library is quite easy! There are three ways to create a player skull.
By name, uuid, and base64/url.

### By Name
The code to create a player skull from a player's name is fairly straightforward:
`SkullCreator.itemFromName("deanveloper")`. This is not recommended as players can change their
name, and change their skin. If either of these happen, the skull produced may not be the expected
skull.

### By UUID (1.13+ only)
The code to create a player skull from a player's UUID is fairly 
straightforward: `SkullCreator.itemWithUuid(itemToMutate, UUID.fromString("4a96ebf7-e27c-41ee-9853-a52ba903fb06"))`.
This should only be used for heads which you want to change when the target player changes their skin. If you
want the skull to stay the same, even after the player changes their skin, check the following methods!

### By Base64 (1.13+ only)
Base64 hashes are how most mapmakers get their heads. They usually go on websites such as [freshcoal], [mineskin],
or [minecraft-heads]. These sites give them very long commands and they can paste them into command blocks which
give them the items. These skulls will ALWAYS have the same skin applied to them, even if the original player has
changed their skin.

What you can do with this plugin is take the base64 from after the `Value:` part of the command, and then
paste that into a method to get the skull. For instance, to get a Stormtrooper skull, you can do this:

```Java
public static ItemStack getStormtrooper() {
    // Got this base64 string from minecraft-heads.com
    String base64 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L" +
     "3RleHR1cmUvNTIyODRlMTMyYmZkNjU5YmM2YWRhNDk3YzRmYTMwOTRjZDkzMjMxYTZiNTA1YTEyY2U3Y2Q1MTM1YmE4ZmY5MyJ9fX0=";

    ItemStack stormtrooper = new ItemStack(Material.SKULL, 1, (byte) 3);
    return SkullCreator.itemWithBase64(base64);
}
```

### By Mojang URL
The base64 strings contain an encoded mojang URL inside of them. If you would not like to store the whole
base64 string (after all, they are very long and gross looking!) you can instead store the link to the url.

```Java
public static ItemStack getCheeseSkull() {
    String s = "http://textures.minecraft.net/texture/955d611a878e821231749b2965708cad942650672db09e26847a88e2fac2946";
    
    ItemStack stormtrooper = new ItemStack(Material.SKULL, 1, (byte) 3);
    return SkullCreator.itemWithUrl(s);
}
```

## Installation
To use this library, you can either copy the class from [GitHub][skullcreator-git] and put it in your project,
or you can get it through Maven.

## Installation with Maven
The project will most likely be added to JCenter at a later point, but for now this
is how to import the project.

First, add the repo into your `pom.xml`...

```xml
<repositories>
    ...
    <repository>
        <id>skullcreator-repo</id>
        <url>https://dl.bintray.com/deanveloper/SkullCreator</url>
    </repository>
    ...
</repositories>
```

Then, add the dependency!

```xml
<dependencies>
    ...
    <!-- SkullCreator -->
    <dependency>
        <groupId>com.deanveloper</groupId>
        <artifactId>skullcreator</artifactId>
        <version>1.0.2</version>
        <scope>compile</scope>
    </dependency>
    ...
</dependencies>
```

Now that you have added the dependency, use `maven-shade-plugin` or `maven-assembler-plugin` to put the plugin in your
jar file. **Be absolutely sure that all dependencies that you don't want inside your jar file (ie Bukkit/Spigot, or other
plugins) have `<scope>provided</scope>`!**

### With `maven-shade-plugin`
Add the following to your `pom.xml`:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>2.4.3</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                          <goal>shade</goal>
                    </goals>
                </execution>
            </executions>
      </plugin>
    </plugins>
</build>
```

### With `maven-assembly-plugin`
Add the following to your `pom.xml`:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-assembly-plugin</artifactId>
            <version>3.0.0</version>
            <configuration>
                <descriptorRefs>
                    <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
            </configuration>
            <executions>
                <execution>
                    <id>make-assembly</id> <!-- this is used for inheritance merges -->
                    <phase>package</phase> <!-- bind to the packaging phase -->
                    <goals>
                        <goal>single</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

## Installation with Gradle
I'm not quite sure how gradle works, but if anyone wants to make a pull request to add an installation guide with
gradle, feel free!

## Donate
I'd really appreciate any donations, even anything as small as a pack of ramen!

[<img src="https://upload.wikimedia.org/wikipedia/commons/b/b5/PayPal.svg" height="50">][paypal]

[freshcoal]: http://heads.freshcoal.com
[mineskin]: https://mineskin.org
[minecraft-heads]: http://minecraft-heads.com/
[skullcreator-git]: https://github.com/Deanveloper/SkullCreator/blob/master/src/main/java/com/deanveloper/skullcreator/SkullCreator.java
[paypal]: https://PayPal.Me/Dean98/5USD
