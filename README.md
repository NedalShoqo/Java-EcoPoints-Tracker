# ♻️ EcoPoints Recycling Tracker

<p align="center">
  A Java-based recycling management system designed to manage households,
  track recycling activities, calculate eco-points, and generate reports.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/OOP-Object--Oriented-blue?style=for-the-badge" alt="OOP">
  <img src="https://img.shields.io/badge/Status-Completed-success?style=for-the-badge" alt="Status">
</p>

---

## 📌 Overview

**EcoPoints Recycling Tracker** is a console-based Java application for managing
households and their recycling activities.

The system allows users to register households, record recycling events,
calculate eco-points based on recycled weight, store data in a file, and
generate basic recycling reports.

---

## ✨ Features

- 🏠 **Household Management**
  - Register households
  - Assign unique household IDs
  - Store household information

- ♻️ **Recycling Event Management**
  - Record recycling material types
  - Track recycled weight
  - Record recycling dates
  - Calculate earned eco-points

- 📊 **Reporting**
  - Display household recycling records
  - Calculate total recycled weight
  - Identify the household with the highest total points

- 💾 **Data Persistence**
  - Save household and recycling information to a text file

- ⚠️ **Error Handling**
  - Validate input values
  - Handle invalid data
  - Handle duplicate household IDs

---

## 🛠️ Technologies & Concepts

| Technology / Concept | Usage |
|---|---|
| **Java** | Core programming language |
| **OOP** | Application structure and modeling |
| **HashMap** | Household storage using unique IDs |
| **ArrayList** | Recycling event storage |
| **Java Streams** | Data processing and reporting |
| **Exception Handling** | Input and runtime error handling |
| **File I/O** | Saving application data |
| **LocalDate** | Recycling dates |
| **LocalDateTime** | Household registration dates |

---

## 📐 Eco-Points Calculation

Eco-points are calculated according to the recycled weight:

```text
Eco Points = Recycled Weight × 10
