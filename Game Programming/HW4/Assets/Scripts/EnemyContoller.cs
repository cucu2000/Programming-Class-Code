using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyContoller : MonoBehaviour
{

    [SerializeField] private Transform player;

    [SerializeField] private float agroRange;

    [SerializeField] private float moveSpeed;

    [SerializeField] private Transform castPoint;

     [SerializeField] public int health;

    private Rigidbody2D rigidbody;

    private bool facingRight = false;
    
// Start is called before the first frame update
    void Start()
    {
        rigidbody = GetComponent<Rigidbody2D>();
        
    }

    // Update is called once per frame
    void Update()
    {
        // float playerDistance = Vector2.Distance(transform.position, player.position);
        //
        // if (playerDistance < agroRange)
        // {
        //     ChasePlayer();
        // }
        // else
        // {
        //     StopChasingPlayer();
        // }

        if (canSeePlayer(agroRange))
        {
            ChasePlayer();
        }
        else
        {
            StopChasingPlayer();
        }
    }

    void ChasePlayer()
    {
        if (transform.position.x < player.position.x)
        {
            rigidbody.velocity = new Vector2(moveSpeed, rigidbody.velocity.y);
            facingRight = true;
        }
        else
        {
            rigidbody.velocity = new Vector2(-moveSpeed, rigidbody.velocity.y);
            facingRight = false;
        }

        if (transform.position.y < player.position.y)
        {
            rigidbody.velocity = new Vector2(rigidbody.velocity.x, moveSpeed);
        }
        else
        {
            rigidbody.velocity = new Vector2(rigidbody.velocity.x, -moveSpeed);
        }
    }

    void StopChasingPlayer()
    {
        rigidbody.velocity= new Vector2(0, 0);
    }

    bool canSeePlayer(float distance)
    {
        bool check = false;
        var castDist = distance;

        if (facingRight == false)
        {
            castDist = -distance;
        }
        
        Vector2 endpos = castPoint.position + Vector3.right * castDist;
        RaycastHit2D hit = Physics2D.Linecast(castPoint.position, endpos, 1 << LayerMask.NameToLayer("Terrain"));

        if (hit.collider != null)
        {
            if (hit.collider.gameObject.CompareTag("Player"))
            {
                check = true;
            }
            else
            {
                check = false;
            }
            
            Debug.DrawLine(castPoint.position, hit.point, Color.red);
        }
        else
        {
            Debug.DrawLine(castPoint.position, endpos, Color.green);
        }

        return check;
    }

   public void dealtDamage()
   {
       health -= 1;
       checkHealth();
   }

    void checkHealth()
    {
        if (health == 0)
        {
            Destroy(gameObject);
        }
    }
    
    
}
