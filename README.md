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

