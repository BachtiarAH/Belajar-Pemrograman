package com.tutorial;

class player{
    String nama;
    double health;
    int level;

    //object 
    weapon senjata;
    armor Armor;

    //set propertyse
    player(String nama, double health, int level){
        this.nama = nama;
        this.health = health;
        this.level = level;
    }

    //equip weapon
    void equipWeapon(weapon senjata){
        this.senjata = senjata;
    }

    //equip armor
    void equipArmor(armor Armor){
        this.Armor = Armor;
    }

    //equip both Equipment

    void equipWeaponAndArmor(weapon senjata, armor Armor){
        this.senjata = senjata;
        this.Armor = Armor;
    }

    //display all property
    void Display(){
        System.out.println("nama   : "+nama);
        System.out.println("health : "+health);
        System.out.println("level  : "+level);
        System.out.println("\nSenjata :");
        System.out.println("nama : "+senjata.nama);
        System.out.println("attk : "+senjata.attackDamage);
        System.out.println("\nArmor :");
        System.out.println("nama : "+Armor.nama);
        System.out.println("deff : "+Armor.deffensePoint);
    }
}

class weapon{
    double attackDamage;
    String nama;

    //set propertyse
    weapon(String nama, double attackDamage){
        this.nama = nama;
        this.attackDamage = attackDamage;
    }
}


class armor{
    String nama;
    double deffensePoint;

    //set propertyse
    armor(String nama,double deffensePoint){
        this.nama = nama;
        this.deffensePoint = deffensePoint;
    }
}
public class Main {
    public static void main(String[] args) {
        //player
        player Pemain = new player("N Y M P H", 100, 10);
        
        //equipment
        weapon pedangBesi = new weapon("Pedang Besi", 10);
        armor zirahBesi = new armor("Zirah Besi", 11);

        //equip Equipment into player
        Pemain.equipWeaponAndArmor(pedangBesi, zirahBesi);

        Pemain.Display();
    }
}
