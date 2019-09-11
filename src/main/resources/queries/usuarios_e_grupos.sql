--QUERY DE USUÁRIOS E GRUPOS

SELECT 
	u.email usuario,
	group_concat(g.nome ORDER BY g.nome separator ', ') grupo
FROM usuario u,
	usuario_grupo ug,
	grupo g
WHERE ug.codigo_usuario = u.codigo
AND ug.codigo_grupo = g.codigo
GROUP BY usuario;