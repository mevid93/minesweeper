**Aihe:** Miinaharavan klooni-versio. Miinaharavassa käytössä on pelilauta, jonka kaikki ruudut ovat alussa paljastamattomia. Laudalla on piilossa miinoja, joiden paikat tulee merkitä lipuilla. Pelaajan on tarkoitus hiirtä käyttäen tyhjentää pelikenttä ja merkitä siinä olevien miinojen sijainnit esille. Vasenta hiiren näppäintä käytetään paljastamattomiin ruutuihin. Ruudut joissa ei ole miinaa, näyttävät klikkauksen jälkeen montako miinaa niiden naapuriruuduissa on. Mikäli ruudussa sattuukin olemaan miina, peli päättyy.

Pelin nopeuttamiseksi tyjää ruutua (ei miinoja naapuriruuduissa) painettaessa peli paljastaa kaikki tyhjät ruudut jotka ovat klikattuun ruutuun yhteydessä. Tämän lisäksi paljastetaan myös ruudut, jotka ovat tyhjän alueen reunoilla ja joiden naapuriruuduissa on miina.

Hiiren oikeaa näppäinta käytetään paljstamattomiin ruutuihin, joissa pelaaja epäilee miinan sijaitsevan. Kun kaikki miinattomat ruudut on käyty läpi, pelaaja voittaa ja tuloksensa on käytetty aika. Pelissä on seuraavat vaikeustasot:

    helppo: pelikenttä on 9 x 9 ruutua ja miinoja on 10.
    keskivaikea: pelikenttä on 16 x 16 ruutua ja miinoja on 40.
    vaikea: pelikenttä on 30 x 16 ruutua ja miinoja on 99.

Näiden lisäksi on myös kustomoitu vaikeustaso, jossa pelikentän koon ja miinojen määrän pelaaja päättää.
** **

**Käyttäjät:** Kuka tahansa, joka haluaa pelata nostalgista peliä.
** **

**Ohjelman käyttäjän toiminnot**: 
- asetusten määrittäminen (pelikentän koon valitseminen)
- uuden pelin aloittaminen (sekä asetusvalikosta, että pelikentän yläpuolella sijaitsevasta napista)
- pelikentän zoomaus (ominaisuus joka lisätään jos aikaa jää)
- ruudun klikkaaminen hiiren vasemmalla painikkeella (mikäli pelaajan mielestä ruudussa ei ole miinaa)
- miinan sijainnin merkitseminen hiiren oikealla painikkeella (mikäli pelaajan mielestä ruudussa on miina)
<br/>
<br/>
<br/>
![Määrittelyvaiheen luokkakaavio](/dokumentaatio/kuvat/viikon3TarkennettuLuokkakaavio.png)
<br/>
<br/>
Yllä esitetty kuva vastaa ohjelman määrittelyvaiheen luokkakaaviota. Kuvassa on esitetty ohjelman kannalta oleellisimmat luokat. Käyttöliittymäluokka on tietysti olennainen osa peliä, mutta se on tästä huolimatta jätetty pois. Lisäksi kuvasta on jätetty pois luokat Paaohjelma ja ValikkoNappienKuuntelija.
