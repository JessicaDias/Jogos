grammar codeFun;

@members {
    public static String grupo="<<587001, 489336>>";  
}

programa: 'fase:' NUM_INT 'inicio' corpo 'fim';
corpo : comandos | ;

declaracoes_objetos: obj_magia | atribuicao ;
atribuicao: IDENT '=' tipo_magia;
obj_magia: 'magia' IDENT;

declaracoes_funcao: 'funcao' IDENT '()' ('{\n'| '{' ) comandos '}';

declaracoes:  declaracoes_objetos
            | declaracoes_funcao;

comandos : (cmd comandos)?;
cmd     : 'andar' '()'
        | 'virar' '()'
        | 'perguntar' '(' expressao ')' resultado
        | repetir 
        | IDENT '()'
        | 'usar' '('IDENT')'
        | declaracoes;

repetir: 'repetir' '(' NUM_INT ')' ('{\n'| '{' ) comandos '}';
tipo: tipo_bloco | tipo_magia;
tipo_bloco : 'grama' | 'lava' | 'pedra' | 'gelo' |
             'espinho' | 'arvore' | 'caixa' | 'inimigo' |
             'fogueira' | 'tronco' | 'fogueira_apagada' | 'chao_pedra' |
             'terra' | 'cabana' | 'arvore_queimada' | 'portal' | 'agua'| 'caixa_misteriosa' ;
tipo_magia : 'fogo' | 'agua' | 'ataque' ;
expressao: 'frente' '==' tipo_bloco '?';
resultado: ('{\n'| '{' ) comandos '}';

COMENTARIO
    : '#' .*? '#' ->skip;

IDENT
    : ('a'..'z'|'A'..'Z'| '_')('a'..'z'|'A'..'Z'|'0'..'9'| '_')*;

NUM_INT
    : ('0'..'9')+ ;

NUM_REAL
    : ('0'..'9')+ '.'('0'..'9')+ ; 

ENTER : ( ' '| '\t'| '\r'| '\n') -> skip;

COMENTARIO_ERRADO :
    { ErrosSintaticos.comentario = true;}
     '#' ~[\n#]* '\n' 
    ;

SIMBOLO_NAO_INDENTIFICADO
    : . 
    ;