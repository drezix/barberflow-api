# Requirements and User Stories - BarberFlow

This document details the Functional Requirements (FR) and Non-Functional Requirements (NFR) for the development of the BarberFlow project, serving as a guide for feature implementation.

---

## 🚀 Functional Requirements (FR)

### 👤 Authentication & User Management

**ID:** FR01
> As a **new client**, I want to **register on the platform using my name, email, and password** so that **I can schedule services**.
* **Acceptance Criteria:**
    1. The provided email must be unique in the system.
    2. The password must meet a minimum security requirement (e.g., 6 characters).
    3. A new user with the `CLIENT` role is created in the database.

---

**ID:** FR02
> As a **registered user**, I want to **log in with my email and password** so that **I can access my profile and features**.
* **Acceptance Criteria:**
    1. The system must validate the credentials against an existing user.
    2. On success, an authentication token (JWT) is returned.
    3. On failure, an appropriate error message ("Invalid credentials") is displayed.

---

**ID:** FR03
> As a **manager**, I want to **register a new barber in the system** so that **they can have their own schedule and receive bookings**.
* **Acceptance Criteria:**
    1. Only users with the `ADMIN` role can access this functionality.
    2. The manager fills in the necessary details for the barber's profile.
    3. A new user with the `BARBER` role is created.

---

### 📅 Scheduling

**ID:** FR04
> As a **client**, I want to **see the available time slots for a specific barber** so that **I can choose the best time for me**.
* **Acceptance Criteria:**
    1. The system must only show future time slots that are not already booked.
    2. The client can navigate between different days.

---

**ID:** FR05
> As a **client**, I want to **book an appointment with a specific barber and service** so that **I can guarantee my spot**.
* **Acceptance Criteria:**
    1. The chosen time slot must be marked as "occupied" and removed from the list of available slots.
    2. The new appointment must appear on the corresponding barber's schedule.
    3. The client receives a visual confirmation or a notification (email/push).

---

**ID:** FR06
> As a **client**, I want to **cancel an appointment that I made** so that **I can free up the time slot for other people**.
* **Acceptance Criteria:**
    1. The option to cancel should only be available up to a predefined time before the appointment (e.g., 2 hours prior).
    2. Upon cancellation, the time slot becomes available again on the barber's schedule.

---

**ID:** FR07
> As a **barber**, I want to **view my daily and weekly schedule** so that **I know which clients and services I will be attending to**.
* **Acceptance Criteria:**
    1. The schedule must list, in chronological order, the client's name, the scheduled service, and the time.
    2. There should be an easy way to navigate between days and weeks.

---

### 🛠️ Services

**ID:** FR08
> As a **manager**, I want to **create, edit, and remove the services offered by the barbershop** so that **the price list and options are always up to date**.
* **Acceptance Criteria:**
    1. The manager must be able to define the name, description, estimated duration, and price for each service.
    2. Only users with the `ADMIN` role can access this functionality.

---

### 💰 Financial

**ID:** FR09
> As a **manager**, I want to **register the payment for a completed appointment** so that **the revenue is accounted for**.
* **Acceptance Criteria:**
    1. The appointment status changes to `COMPLETED`.
    2. A financial transaction with the service's value is created and associated with the appointment.

---

**ID:** FR10
> As a **manager**, I want to **view a revenue report by period (day, week, month)** so that **I can track the financial health of the business**.
* **Acceptance Criteria:**
    1. The report must sum all completed transactions within the selected period.
    2. It must be possible to filter the report by time period.

---
---

## ⚙️ Non-Functional Requirements (NFR)

### 🔒 Security

**ID:** NFR01
* **Requirement:** All user passwords must be securely stored in the database.
* **Acceptance Criteria:**
    1. Passwords are never saved in plain text.
    2. A strong hashing algorithm (like bcrypt) is used at registration and for verification at login.

---

**ID:** NFR02
* **Requirement:** API access must be protected and restricted to authenticated users with the correct permission (role).
* **Acceptance Criteria:**
    1. Management endpoints (e.g., create service, view revenue) can only be accessed by users with the `ADMIN` role.
    2. A `CLIENT` user cannot view or modify another client's data.

---

### ⚡ Performance

**ID:** NFR03
* **Requirement:** The response time for key API calls (e.g., fetching available time slots) must be under 500 milliseconds under normal usage conditions.
* **Acceptance Criteria:**
    1. Load tests are performed to validate response times under moderate stress.
    2. Indexes are created on the most frequently queried database columns to optimize queries.

---

### ✨ Usability

**ID:** NFR04
* **Requirement:** The booking flow in the mobile application must be intuitive and completable in a maximum of 4 steps/screens.
* **Acceptance Criteria:**
    1. Usability tests are conducted with at least 3 users to validate the ease and clarity of the flow.

---

### 🖥️ Compatibility

**ID:** NFR05
* **Requirement:** The web administration panel must function correctly on the latest versions of Chrome, Firefox, and Edge browsers.
* **Acceptance Criteria:**
    1. Visual and functional compatibility tests are executed on the target browsers before launch.
