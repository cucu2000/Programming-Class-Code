using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerController : MonoBehaviour
{
    [Range(0, 1000f)] [SerializeField] private float speed = 500;
    [Range(0, 100f)] [SerializeField] private float jumpForce = 5;
    private Rigidbody2D rigidbody;
    private SpriteRenderer spriteRenderer;
//    GameObject spawnPoint;
    private float verticalInput;
    //private Animator anim;
    private bool isGrounded = false;
    //public Animator animate;

    // Start is called before the first frame update
    void Start()
    {
        rigidbody = GetComponent<Rigidbody2D>();
        spriteRenderer = GetComponent<SpriteRenderer>();
        //anim = GetComponent<Animator>();
//        spawnPoint = GameObject.FindGameObjectWithTag("SpawnPoint");
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void FixedUpdate()
    {
        Move();
    }

    void Move()
    {
        float horizontalInput = Input.GetAxis("Horizontal") * Time.deltaTime * speed;

        if (horizontalInput < 0)
        {
            //animate.SetFloat("speed", Mathf.Abs(horizontalInput));
            spriteRenderer.flipX = false;
//            anim.SetBool("Moving", true);
        }
        else if (horizontalInput > 0)
        {
            //animate.SetFloat("speed", Mathf.Abs(horizontalInput));
            spriteRenderer.flipX = true;
//            anim.SetBool("Moving", true);
        }
        else
        {
//            anim.SetBool("Moving", false);
        }

        if (rigidbody.velocity.y >= -0.01 && rigidbody.velocity.y <= 0.01)
        {
            //animate.SetBool("grounded", true);
            isGrounded = true;
        }

        if (Input.GetKey(KeyCode.Space) && isGrounded)
        {
            //animate.SetBool("grounded", false);
            isGrounded = false;
            rigidbody.velocity = new Vector2(0, jumpForce);
        }

        rigidbody.velocity = new Vector2(horizontalInput, rigidbody.velocity.y);


    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        print(collision.name);
    }


    private void OnCollisionEnter2D(Collision2D collision)
    {
        print(collision.gameObject.name);
    }

}
