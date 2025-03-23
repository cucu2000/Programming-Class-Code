using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerAttack : MonoBehaviour
{
   
    public Transform attackPoint;
    
    [SerializeField]
    private GameObject arrow;
    
    [SerializeField]
    Transform arrowSpawn;
    
    [SerializeField]
    float shootDelay;

    bool isShooting = false;

    private EnemyContoller enemyContoller;

    void Update()
    {
        if (Input.GetKey(KeyCode.Mouse0))
        {
            if (isShooting)
                return;

            print("Shoot");
            isShooting = true;

            GameObject arr = Instantiate(arrow, arrowSpawn.position, Quaternion.identity);
            Invoke("ResetShoot", shootDelay);
        }
    }

    void ResetShoot()
    {
        isShooting = false;
    }
    
}
