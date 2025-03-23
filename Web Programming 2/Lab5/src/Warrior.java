public class Warrior {

    //field
    Weapon weapon;

    //methods
    void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    void Attack(){
        if(weapon == null){
            System.out.println("Attack with Fist");
        }else{
            weapon.Attack();
        }
    }

    //contructors
}
