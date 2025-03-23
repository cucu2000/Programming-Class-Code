using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Arrow : MonoBehaviour
{
    [SerializeField] private int arrowSpeed;

    private Rigidbody2D rigidbody;

    private GameObject enemy;

    private GameObject wall;

    // Start is called before the first frame update
    void Start()
    {
        rigidbody = GetComponent<Rigidbody2D>();
        enemy = GameObject.FindWithTag("Enemy");
        wall = GameObject.FindWithTag("MazeWall");
    }

    // Update is called once per frame
    void Update()
    {
        rigidbody.velocity = new Vector2(arrowSpeed * Time.fixedDeltaTime, 0f);
    }

    private IEnumerator OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("MazeWall"))
        {
            yield return new WaitForSeconds(1f);
            Destroy(gameObject);
        }
        
        else if (collision.gameObject.CompareTag("Enemy"))
        {
            Destroy(gameObject);
            enemy.GetComponent<EnemyContoller>().dealtDamage();
        }
        
        else
        {
            Destroy(gameObject);
        }
    }
}
