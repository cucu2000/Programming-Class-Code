using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour
{
    
    [SerializeField] private float speed;
    private Rigidbody2D rigidbody;
    private GameObject Spawn;
    private SpriteRenderer spriteRenderer;
    
    
    // Start is called before the first frame update
    void Start()
    {
        rigidbody = GetComponent<Rigidbody2D>();
        Spawn = GameObject.FindGameObjectWithTag("Spawn");
        spriteRenderer = GetComponent<SpriteRenderer>();
        
    }

    // Update is called once per frame
    void Update()
    {
        float horizontalInput = Input.GetAxis("Horizontal") * speed;

        float verticalaInput = Input.GetAxis("Vertical") * speed;
        
        rigidbody.velocity = new Vector2(horizontalInput, verticalaInput);

        if (horizontalInput > 0)
        {
            spriteRenderer.flipX = true;
        }
        else if (horizontalInput < 0) 
        {
            spriteRenderer.flipX = false;
        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "MazeWall")
        {
            MainGame.setCollisions();
            rigidbody.position = new Vector2(Spawn.transform.position.x, Spawn.transform.position.y);
            FindObjectOfType<AudioManager>().Play("WallSound");
        }

        if (collision.gameObject.tag == "Gem")
        {
            MainGame.addItem();
            collision.gameObject.SetActive(false);
            FindObjectOfType<AudioManager>().Play("GemSound");
        }
    }
}
