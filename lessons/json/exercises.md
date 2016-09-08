# In class exercises
        
### Q1. Write a JSON object to represent the following instance of the `Pizza` class:

```java
Pizza pizza = new Pizza("Mozzarella", "3", true);

// Pizza.java
public class Pizza {
    String cheese;
	int toppingCount;
	boolean fresh;
    
    public Pizza(String cheese, int toppingCount, boolean fresh) {
        this.cheese = cheese;
        this.toppingCount = toppingCount;
        this.fresh = fresh;
    }
}
```

### Q2. Write a JSON object to represent the following instance of this all-new, snazzier `Pizza` class:

```java
Pizza pizza = new Pizza("Provolone", false, new String[]{"Anchovies", "Olives", "Pineapple"});

// Pizza.java
public class Pizza {
    String cheese;
    String[] toppings;
    boolean fresh;
	
    public Pizza(String cheese, int toppingCount, String[] toppings, boolean fresh) {
        this.cheese = cheese;
        this.toppings = toppings;
        this.fresh = fresh;
    }
}
```

### Q3. Write a JSON parser for the `Pizza` class (from Q2) that parses your pizza JSON object.

### Q4. Write a Java class `Message` that represents the each of the following Slack `message` JSON objects.

a. A simple message with text attachment.
```json
{
    "text": "I am a test message http://slack.com",
    "attachments": [
        {
            "text": "And here's an attachment!"
        }
    ]
}
```

b.
```json
{
    "text": "Would you like to play a game?",
    "attachments": [
        {
            "text": "Choose a game to play",
            "fallback": "You are unable to choose a game",
            "callback_id": "wopr_game",
            "color": "#3AA3E3",
            "attachment_type": "default",
            "actions": [
                {
                    "name": "chess",
                    "text": "Chess",
                    "type": "button",
                    "value": "chess"
                },
                {
                    "name": "maze",
                    "text": "Falken's Maze",
                    "type": "button",
                    "value": "maze"
                },
                {
                    "name": "war",
                    "text": "Thermonuclear War",
                    "style": "danger",
                    "type": "button",
                    "value": "war",
                    "confirm": {
                        "title": "Are you sure?",
                        "text": "Wouldn't you prefer a good game of chess?",
                        "ok_text": "Yes",
                        "dismiss_text": "No"
                    }
                }
            ]
        }
    ]
}
```

### Q5. Write a JSON parser for the `Message` class that parses a Slack `message` JSON object.

### Q6. Write a Java class `Channel` that represents a Slack `channel` JSON object.

```json
{
    "id": "C024BE91L",
    "name": "fun",
    "is_channel": "true",
    "created": 1360782804,
    "creator": "U024BE7LH",
    "is_archived": false,
    "is_general": false,

    "members": [
        "U024BE7LH",
        
    ],

    "topic": {
        "value": "Fun times",
        "creator": "U024BE7LV",
        "last_set": 1369677212
    },
    "purpose": {
        "value": "This channel is for fun",
        "creator": "U024BE7LH",
        "last_set": 1360782804
    },

    "is_member": true,

    "last_read": "1401383885.000061",
    "latest": {
        "text": "I am a test message http://slack.com",
        "attachments": [
            {
                "text": "And here's an attachment!"
            }
        ]
    },
    "unread_count": 0,
    "unread_count_display": 0
}
```

### Q7. Write a JSON parser for the `Channel` class that parses a Slack `channel` JSON object.

### Q8. Think of some web services that you like to use (e.g. Facebook, Twitter, Google Maps, Snapchat...). Search Google to find one that has a public API. 
    a. In what ways does the API allow developers to interact with the service? 
    b. If there is a REST API, what endpoints does it offer? 
    c. How does the service format responses (e.g. JSON, XML...)
