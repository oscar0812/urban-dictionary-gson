# urbandictionary-gson
A Java urban-dictionary wrapper that uses the GSON library

## Installation
Download the jar artifact from out/artifacts/urban_dictionary_gson_jar/... and import it into your IDE.

# Main Files
### UrbanDictionary.java
UrbanDictionary fetches the API and sets the fields for Definition

### Definition.java
Definition holds the information for the API fetch.
```java
public String definition;
public String permalink;
public int thumbs_up;
public String[] sound_urls;
public String author;
public String word;
public long defid;
public String current_vote;
public String written_on;
public String example;
public int thumbs_down;
```

# Usage

Import:
```java
import com.bittle.urbandictionary.Definition;
import com.bittle.urbandictionary.UrbanDictionary;
```

Lookup by term:
```java
Definition[] ds = UrbanDictionary.define("dog");
```

Lookup by ID:
```java
Definition[] ds = UrbanDictionary.defineByID(100);
```

Lookup random words:
```java
Definition[] ds = UrbanDictionary.random();
```

Read definitions:
```java
for (Definition d: ds) {
            System.out.println(d.definition);
}

// OUTPUT:
Not [a cat].

[Gotta love] [Blackadder].

not [a cat]
[Australian slang] for [police] [informant].
a [companion], [friend], [homie]
verb: to follow closely behind, or to check (someone) frequently, implies that the action causes some annoyance or [interference] (from the fact that a pet dog will often follow closely at its [master's] [heels]).
// ...
```