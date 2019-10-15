# NameFinder
NameFinder using Apache OpenNLP

Download the models for each language and place it under the input directory.
```
http://opennlp.sourceforge.net/models-1.5/
```

Running with maven:
```
mvn spring-boot:run
```

Frontend:
```
http://localhost:8080/
```

Swagger:
```
http://localhost:8080/swagger-ui.html
```

TODO:
* Improve entity extraction
* Integrate an OCR library (OpenCV, Tesseract, ...)
* Akka for parallelization 
