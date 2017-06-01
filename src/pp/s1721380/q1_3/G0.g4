grammar G0;

c: p 'class' ID x y;
p: 'public' | ;
x: 'extends' ID | ;
y: 'implements' i ID | ;
i: ID ',' i | ;

//C: P 'class' ID X Y;
//P: 'public' | /* epsilon */ ;
//X: 'extends' ID | /* epsilon */ ;
//Y: 'implements' I ID | /* epsilon */ ;
//I: ID ',' I | /* epsilon */ ;
ID: ('a'..'z')*;