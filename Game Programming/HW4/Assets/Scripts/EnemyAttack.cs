using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyAttack : MonoBehaviour
{
    [SerializeField]
    Transform player;

    [SerializeField]
    float attackRange;

    [SerializeField]
    float attackSpeed;

    Rigidbody2D enemy;

    void Start()
    {
        enemy = GetComponent<Rigidbody2D>();
        player = GameObject.FindGameObjectWithTag("Player").transform;
    }

    // Update is called once per frame
    void Update()
    {
        float distanceToPlayer = Vector2.Distance(transform.position, player.position);

        if (distanceToPlayer < attackRange)
        {
            //Chase
            if (transform.position.x < player.position.x)
                enemy.velocity = new Vector2(attackSpeed, 0);
            else
                enemy.velocity = new Vector2(-attackSpeed, 0);
        }
        else
        {
            //Stop
            enemy.velocity = Vector2.zero;
        }
    }
}
