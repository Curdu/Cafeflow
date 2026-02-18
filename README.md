# CafeFlow

## Requisits CafeFlow
***

### **Requisits Visuals:**
---

La aplicació ha de contenir les següents pantalles:
- [x] ActivityLogin
- [x] ActivityRegistre
- [x] ActivityMenu
- [x] FragmentMenjar
- [x] FragmentBeguda
- [x] FragmentPostres
- [x] FragmentTotal

Cada pantalla ha de cumplir uns requisits especificats a continuació:

### ActivityLogin

Ha de tenir dos camps de text, el primer per l'**Usuari** i el segon per la **Contrasenya**.
A més a més ha de tenir un **Boto per iniciar sessió** i un **link amb el text** _"No tens compte? Registra't"_.

### ActivityRegistre

Ha de tenir tres camps de text, el primer demana el **Nom de l'usuari**, el segon, el **Correu** i el tercer, la **Contrasenya**.
També ha de tenir un **Botó per crear l'usuari** i un **link** amb el text _"Ja tens compte? Inicia Sessió"_

### ActivityMenu

Ha de ser un menú amb tres botons principals que són: el **Botó de Menjar**, el **Botó de Begudes** i el **Botó de Postres**
A la part superior de la pantalla ha de tenir una **Activity Bar amb el preu acumulat**.
A la part inferior dreta ha d'haver el **Botó de cistella**.

### FragmentMenjar

S'ha de veure un llistat de tots els Menjars disponibles i afegir menjars a la taula

### FragmentBeguda

S'ha de veure un llistat de tots els Begudes disponibles i afegir begudes a la taula


### FragmentPostres

S'ha de veure un llistat de tots els Postres disponibles i afegir begudes a la taula

### FragmentTotal

S'ha de poder visualitzar tots els productes triats per l'usuari i un botó de pagar.

### **Requisits funcionals**
---

L'aplicació de Cafe flow ha de cumplir uns requisits funcionals mínims que són:

- Les dades de ActivityLogin i ActivityRegistre s'han de **guardar de manera persistent** utilitzant **SharedPreferences**
- Menjars, Begudes, Postres i Pagament han de ser **Fragments**.
- Menjars, Begudes i Postres han de mostrar el llistat de productes amb un **RecyclerView** i permetre afegir productes a la cistella.
- Pagament ha de tenir un **RecyclerView** amb els productes triats i es podrà pagar la comanda. Quan es paga una comanda es guarda un **registre a la BBDD** amb el preu i l'usuari que ha pagat.
- Cada fragment ha de tenir el seu propi **ViewModel** corresponent.
- S'ha de crear un **SharedViewModel** per poder compartir dades entre fragments.

## Fase Firebase:
---

### Objectius

- Modificar l'autenticació d'usuaris per que es faci mitjançant **Authentication** de firebase.
- Mantenir la informació dels productes en el Room de l'aplicació.
- Crear la pantalla d'historial, on es mostraràn totes les comandes de l'usuari i el preu d'aquestes que estaran guardades a firebase
- Guardar la comanda actual a firebase per a que quan inici sessió recuperi la comanda

### Modificacions a realitzar

- [x] Crear el fitxer **UserAuth** dins del paquet _firebase_ amb una funció per iniciar sessió i una altre per registrar-se.
- [x] Modifcar **UsuariRepositori** per utilitzar aquestes funcions en comptes de les que fan servir shared_preferences
- [ ] Crear **ComandesFirebase** dins del paquet _firebase_ on es crearán funcions corresponents a un CRUD.
- [ ] Crear la pantalla de **Historial** amb el seu recycler view corresponent i HistorialVM.
- [ ] Modificar el **SharedViewModel** per a que quan s'afegeixi/elimini un producte a la comanda es faci el canvi a firebase.