#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>
int main(){
pid_t pid, pid1;
/* create a chid process */
 pid = fork();
if(pid < 0) { /* error occured */
fprintf(stderr, " Fork Failed ");
return 1;
}
else if (pid == 0 ) {/* child process */
 pid1 = getpid();
printf(" child: pid = %d",pid); /* A */
printf(" child: pid1 = %d",pid1); /* B */
}
else { /* parent process */
 pid1 = getpid();
printf(" parent: pid = %d",pid); /* C */
printf(" parent: pid1 = %d",pid1); /* D */
wait(NULL);
}
return 0;
}/* end of main