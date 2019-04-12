use partidas_futebola;


select * from time;
select * from partida;

drop trigger aumentaPontuacao;

delimiter $
create trigger aumentaPontuacao after insert on partida for each row
begin
	
	if new.pontuacao1 > new.pontuacao2 then
		update time t join partida p on p.time1_codigo = t.codigo set t.pontuacao = t.pontuacao+3 where t.codigo = p.time1_codigo;
	end if;
    
    if new.pontuacao2 > new.pontuacao1 then
		update time t join partida p on p.time2_codigo = t.codigo set t.pontuacao = t.pontuacao+3 where t.codigo = p.time2_codigo;
	end if;
	
    if new.pontuacao1 = new.pontuacao2 then
		update time t join partida p on p.time1_codigo = t.codigo set t.pontuacao = t.pontuacao+1 where t.codigo = p.time1_codigo;
        update time t join partida p on p.time2_codigo = t.codigo set t.pontuacao = t.pontuacao+1 where t.codigo = p.time2_codigo;
	end if;

end$
delimiter ;

