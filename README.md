# Lab 11 — Mutation Testing (PIT)

## Оюутны мэдээлэл

- Овог нэр: Б.Мөнгөншагай
- Оюутны код: B232270013
- Хичээл: F.CSA313
- Лаборатори: №11

## Ажлын орчин

```text
openjdk version "17.0.21.0.3" 2026-10-24
OpenJDK Runtime Environment (build 17.0.21.0.3+1)
OpenJDK 64-Bit Server VM (build 17.0.21.0.3+1, mixed mode, sharing)
Apache Maven 3.10.0 (c43a36b8d67be7e0805a411bc0898af1a51f5472)
Maven home: /usr/share/java/maven
Java version: 17.0.21.0.3, vendor: Arch Linux, runtime: /usr/lib/jvm/java-17-openjdk
Default locale: en_US, platform encoding: UTF-8, time zone: Asia/Ulaanbaatar
OS name: "linux", version: "6.18.60-1-lts", arch: "amd64", family: "unix"
git version 2.56.0
```

## 1. Лабораторийн зорилго

JaCoCo болон PIT хэрэгслийг ашиглан кодын хамралт,
тестийн чанарын ялгааг судлах, амьд үлдсэн мутантуудыг
ангилах, assertion болон зааг утгын тестүүдийг сайжруулах
замаар mutation coverage-ийг нэмэгдүүлэх.

## 2. Анхны хэмжилт

### 2.1. JaCoCo

| Үзүүлэлт | Үр дүн |
|---|---:|
| Instruction Coverage | 152/152 (100%) |
| Line Coverage | 25/25 (100%) |
| Branch Coverage | 38/41 (92.68%) |
| Method Coverage | 4/4 (100%) |

![JaCoCo starter report](evidence/01-jacoco-start.png)

Нотолгоо:

- [Maven verify](results/mvn-verify-start.txt)
- [JaCoCo CSV](results/jacoco-start.csv)

### 2.2. PIT Mutation Testing

| Үзүүлэлт | Үр дүн |
|---|---:|
| Generated mutations | 63 |
| Killed | 17 |
| Survived | 46 |
| No coverage | 0 |
| Mutation Coverage | 27% |
| Test Strength | 27% |

![PIT starter report](evidence/02-pit-start.png)

Нотолгоо:

- [PIT console output](results/pit-start.txt)
- [PIT HTML report](results/pit-report-start/index.html)

### 2.3. Анхны ажиглалт

JaCoCo-ийн Line Coverage 100% байгаа боловч PIT-ийн
Mutation Coverage ердөө 27% байна. Нийт 63 мутантаас
17-г тестүүд илрүүлж, 46 мутант амьд үлдсэн нь кодын
бүх мөрийг ажиллуулсан ч түүний зөв үр дүнг хангалттай
шалгаагүйг харуулж байна. Иймээс өндөр кодын хамралт
дангаараа тестийн чанарыг батлахгүй.


## 3. Хэсэг A — Амьд мутантуудын ангилал

Анхны PIT хэмжилтээр 63 мутантаас 17 нь KILLED,
46 нь SURVIVED төлөвтэй гарсан.

Мутацийн тайлбарын товчлол:

- Boundary: changed conditional boundary.
- Compare true/false: removed conditional - replaced comparison check with true/false.
- Equality true/false: removed conditional - replaced equality check with true/false.
- Empty return: replaced return value with "".
- Int return 0: replaced int return with 0.
- Double return 0: replaced double return with 0.0d.
- Addition to subtraction: Replaced double addition with subtraction.
- Switch default: Changed switch default to be first case.

### A1. letterGrade()

| Мөр | Мутаци | Тоо | Ангилал | Үндэслэл | Арга хэмжээ |
|---:|---|---:|---|---|---|
| 20 | Boundary | 2 | Тест дутуу | 0 болон 100 зөвшөөрөгдөх зан төлөв өөрчлөгдөнө. | 0, 100 шалгах |
| 23 | Boundary | 1 | Тест дутуу | 90 онооны үнэлгээ өөрчлөгдөнө. | 90, 89.99 шалгах |
| 23 | Compare true/false | 2 | Тест дутуу | A үнэлгээ авах нөхцөл өөрчлөгдөнө. | Яг үнэлгээг assertEquals-оор шалгах |
| 23 | Empty return | 1 | Тест дутуу | A-ийн оронд хоосон мөр буцаана. | assertEquals("A", ...) |
| 24 | Boundary | 1 | Тест дутуу | 80 онооны үнэлгээ өөрчлөгдөнө. | 80, 79.99 шалгах |
| 24 | Compare true/false | 2 | Тест дутуу | B үнэлгээ авах нөхцөл өөрчлөгдөнө. | Яг үнэлгээг шалгах |
| 24 | Empty return | 1 | Тест дутуу | B-ийн оронд хоосон мөр буцаана. | assertEquals("B", ...) |
| 25 | Boundary | 1 | Тест дутуу | 70 онооны үнэлгээ өөрчлөгдөнө. | 70, 69.99 шалгах |
| 25 | Compare true/false | 2 | Тест дутуу | C үнэлгээ авах нөхцөл өөрчлөгдөнө. | Яг үнэлгээг шалгах |
| 25 | Empty return | 1 | Тест дутуу | C-ийн оронд хоосон мөр буцаана. | assertEquals("C", ...) |
| 26 | Boundary | 1 | Тест дутуу | 60 онооны үнэлгээ өөрчлөгдөнө. | 60, 59.99 шалгах |
| 26 | Compare true/false | 2 | Тест дутуу | D үнэлгээ авах нөхцөл өөрчлөгдөнө. | Яг үнэлгээг шалгах |
| 26 | Empty return | 1 | Тест дутуу | D-ийн оронд хоосон мөр буцаана. | assertEquals("D", ...) |
| 27 | Empty return | 1 | Тест дутуу | F-ийн оронд хоосон мөр буцаана. | assertEquals("F", ...) |
| | Нийт | 19 | | | |

### A2. gpa()

| Мөр | Мутаци | Тоо | Ангилал | Үндэслэл | Арга хэмжээ |
|---:|---|---:|---|---|---|
| 36 | Switch default | 1 | Тест дутуу (урьдчилсан) | Default салааны өөрчлөлт F үнэлгээний голчид нөлөөлж болзошгүй. | F үнэлгээний GPA-г 0.0 гэж шалгаж дахин хэмжих |
| 38 | Addition to subtraction | 1 | Тест дутуу | B үнэлгээний 3 оноог нэмэхийн оронд хасна. | B үнэлгээний GPA-г яг утгаар шалгах |
| 40 | Addition to subtraction | 1 | Тест дутуу | D үнэлгээний 1 оноог нэмэхийн оронд хасна. | D үнэлгээний GPA-г яг утгаар шалгах |
| 44 | Double return 0 | 1 | Тест дутуу | Бодсон голчийн оронд 0.0 буцаана. | GPA-ийн хүлээгдсэн утгыг assertEquals-оор шалгах |
| | Нийт | 4 | | | |

### A3. scholarship()

| Мөр | Мутаци | Тоо | Ангилал | Үндэслэл | Арга хэмжээ |
|---:|---|---:|---|---|---|
| 48 | Boundary | 2 | Тест дутуу | Хүчинтэй оролтын доод хязгаарын зан төлөв өөрчлөгдөнө. | GPA 0, credits 0 шалгах |
| 48 | Compare true | 1 | Тест дутуу | Оролтын баталгаажуулалтын нөхцөл өөрчлөгдөнө. | Сөрөг GPA зэрэг буруу оролт шалгах |
| 51 | Equality true/false | 2 | Тест дутуу | Сахилгын зөрчилтэй болон зөрчилгүй оюутны тэтгэлгийн үр дүн өөрчлөгдөнө. | hasViolation true/false үед яг утгыг шалгах |
| 52 | Boundary | 2 | Тест дутуу | GPA 3.8, credits 15 зааг дээр 100%-ийн тэтгэлэг өөрчлөгдөнө. | 3.8, 3.79 болон 15, 14 шалгах |
| 52 | Compare true/false | 4 | Тест дутуу | 100%-ийн тэтгэлгийн GPA эсвэл кредитийн шаардлага алдагдана. | Нөхцөл тус бүрийг үнэн, худал утгаар шалгах |
| 52 | Int return 0 | 1 | Тест дутуу | 100%-ийн оронд 0% буцаана. | assertEquals(100, ...) |
| 53 | Boundary | 2 | Тест дутуу | GPA 3.4, credits 12 зааг дээр 70%-ийн тэтгэлэг өөрчлөгдөнө. | 3.4, 3.39 болон 12, 11 шалгах |
| 53 | Compare true/false | 4 | Тест дутуу | 70%-ийн тэтгэлгийн GPA эсвэл кредитийн шаардлага алдагдана. | Нөхцөл тус бүрийг үнэн, худал утгаар шалгах |
| 53 | Int return 0 | 1 | Тест дутуу | 70%-ийн оронд 0% буцаана. | assertEquals(70, ...) |
| 54 | Boundary | 1 | Тест дутуу | GPA 3.0 зааг дээр 50%-ийн тэтгэлэг өөрчлөгдөнө. | 3.0, 2.99 шалгах |
| 54 | Compare true/false | 2 | Тест дутуу | 50%-ийн тэтгэлэг авах нөхцөл өөрчлөгдөнө. | GPA 3.0-аас их, бага утга шалгах |
| 54 | Int return 0 | 1 | Тест дутуу | 50%-ийн оронд 0% буцаана. | assertEquals(50, ...) |
| | Нийт | 23 | | | |

### A4. Ангиллын нэгтгэл

| Метод | SURVIVED |
|---|---:|
| letterGrade() | 19 |
| gpa() | 4 |
| scholarship() | 23 |
| Нийт | 46 |

45 мутант нь зан төлөвийг өөрчлөх боломжтой тул
тест дутуу гэж ангилсан. Switch default мутантыг
урьдчилсан байдлаар тест дутуу гэж ангилсан бөгөөд
яг утгын тест нэмсний дараа дахин үнэлнэ.

Анхны тестийн багцад assertNotNull болон муж шалгах
assertTrue өргөн ашигласнаас буруу буцаах утгууд
илрээгүй байна. Мөн зааг утгуудыг бүрэн шалгаагүй
нь conditional boundary мутантууд амьд үлдэхэд
нөлөөлсөн.

Нотолгоо:
[Анхны дэлгэрэнгүй PIT тайлан](results/pit-report-start/mn.edu.must.sqat/ScholarshipCalculator.java.html)


## 4. Хэсэг B — Тестүүдийг хүчтэй болгох

### B1. Assertion-уудыг сайжруулах

Starter тестийн багцын 13 сул assertion-ийг
хүлээгдэж буй утгыг яг шалгадаг assertEquals
болгон өөрчилсөн.

- letterGrade(): 5 assertNotNull-ийг assertEquals болгосон.
- gpa(): 3 муж шалгасан assertTrue-г assertEquals болгосон.
- scholarship(): 5 муж шалгасан assertTrue-г assertEquals болгосон.

Энэ шатанд шинэ тестийн оролт нэмээгүй.
JUnit-ийн 6 тест бүгд амжилттай ажилласан.

### B1-ийн хэмжилт

| Үзүүлэлт | Starter | B1 |
|---|---:|---:|
| JUnit tests | 6 | 6 |
| Line Coverage | 100% | 100% |
| Generated mutations | 63 | 63 |
| Killed | 17 | 45 |
| Survived | 46 | 18 |
| No Coverage | 0 | 0 |
| Mutation Coverage | 27% | 71% |
| Test Strength | 27% | 71% |

![PIT B1 report](evidence/03-pit-B1.png)

### Мутацийн төрлүүдийн харьцуулалт

| Mutator | Generated | Starter Killed | B1 Killed | B1 Survived |
|---|---:|---:|---:|---:|
| RemoveConditional_ORDER_ELSE | 14 | 5 | 14 | 0 |
| PrimitiveReturns | 4 | 0 | 4 | 0 |
| ConditionalsBoundary | 14 | 1 | 1 | 13 |
| Switch | 1 | 0 | 1 | 0 |
| RemoveConditional_EQUAL_ELSE | 3 | 2 | 3 | 0 |
| RemoveConditional_ORDER_IF | 14 | 4 | 9 | 5 |
| Math | 5 | 3 | 5 | 0 |
| EmptyObjectReturnVals | 5 | 0 | 5 | 0 |
| RemoveConditional_EQUAL_IF | 3 | 2 | 3 | 0 |
| Нийт | 63 | 17 | 45 | 18 |

### B1-ийн ажиглалт

Зөвхөн assertion-уудыг сайжруулснаар нэмэлт 28
мутант илэрч, Mutation Coverage 27%-аас 71%
буюу тайланд харуулсан хувиар 44 нэгж хувиар өссөн.
Тестийн тоо болон Line Coverage өөрчлөгдөөгүй
боловч тестийн чанар мэдэгдэхүйц сайжирсан.

Үлдсэн 18 мутантын 13 нь conditional boundary,
5 нь RemoveConditional_ORDER_IF төрлийн мутант
байна. Эдгээрийг B2 шатанд зааг утга болон
нөхцөлийн тестүүдээр шалгана.

Хэсэг A-д урьдчилсан байдлаар ангилсан 36-р
мөрийн Switch default мутант B1 дээр KILLED
болсон. Иймээс уг мутант equivalent биш,
харин assertion сул байснаас амьд үлдсэн
гэдэг нь батлагдсан.

Нотолгоо:

- [JUnit B1](results/mvn-test-B1.txt)
- [PIT B1](results/pit-B1.txt)
- [PIT B1 HTML report](results/pit-report-B1/index.html)

