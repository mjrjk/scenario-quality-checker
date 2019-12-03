# scenario-quality-checker
Application for analysing scenarios<br /><br />
[![Build Status](https://travis-ci.org/mjrjk/scenario-quality-checker.svg?branch=master)](https://travis-ci.org/mjrjk/scenario-quality-checker)
<br /><br />
Notacja scenariuszy:<br />
• Scenariusz zawiera nagłówek określający jego tytuł i aktorów (zewnętrznych oraz system)<br />
• Scenariusz składa się z kroków (każdy krok zawiera tekst)<br />
• Kroki mogą zawierać pod-scenariusze (dowolny poziom zagłębień)<br />
• Kroki mogą się zaczynać od słów kluczowych: IF, ELSE, FOR EACH<br />
<br />
Przykład:<br />
Tytuł: Dodanie książki<br />
Aktorzy:  Bibliotekarz<br />
Aktor systemowy: System<br />
<br />
• Bibliotekarz wybiera opcje dodania nowej pozycji książkowej<br />
• Wyświetla się formularz.<br />
• Bibliotekarz podaje dane książki.<br />
• IF: Bibliotekarz pragnie dodać egzemplarze książki<br />
    o Bibliotekarz wybiera opcję definiowania egzemplarzy<br />
    o System prezentuje zdefiniowane egzemplarze<br />
    o FOR EACH egzemplarz:<br />
        • Bibliotekarz wybiera opcję dodania egzemplarza<br />
        • System prosi o podanie danych egzemplarza<br />
        • Bibliotekarz podaje dane egzemplarza i zatwierdza.<br />
        • System informuje o poprawnym dodaniu egzemplarza i prezentuje zaktualizowaną listę egzemplarzy.<br />
• Bibliotekarz zatwierdza dodanie książki.<br />
• System informuje o poprawnym dodaniu książki.
