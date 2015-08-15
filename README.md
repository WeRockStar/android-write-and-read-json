# Android-Write-Read-JSON-Basic
JsonWriter and JsonReader , No Library


#### JsonWriter
```java
try{
    JsonWriter jsonWriter = new JsonWriter(
      new OutputStreamWriter(openFileOutput("data.json" , MODE_PRIVATE)));
    try{
        jsonWriter.setIndent("  ");

        jsonWriter.beginObject();
        jsonWriter.name("name");
        jsonWriter.value("Kocthaphan Muangsan");
        jsonWriter.name("email");
        jsonWriter.value("kotchaphan.m@kkumail.com");
        jsonWriter.endObject();
    }finally {
        jsonWriter.close();
    }
}catch (IOException ex){
    ex.printStackTrace();
}
  ```
  
  
  #### JsonReader
  ```java
try{
       JsonReader jsonReader = new JsonReader(new InputStreamReader((openFileInput("data.json"))));
        try{
            jsonReader.beginObject();

            while (jsonReader.hasNext()){
                String name = jsonReader.nextName();
                if("name".equals(name)){
                    txtName.setText(jsonReader.nextString());
                }else if("email".equals(name)){
                    txtValue.setText(jsonReader.nextString());
                 }else{
                    //Unkhonw attribute
                    jsonReader.skipValue();
                 }
            }
            jsonReader.endObject();
        }finally {
            jsonReader.close();
        }
}catch (IOException e){
       e.printStackTrace();
}
```
  
