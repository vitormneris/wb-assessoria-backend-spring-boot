package com.br.wb.dto.proceedings;

public class Teste {
    public class Assunto
    {
        public int codigo { get; set; }
        public string nome { get; set; }
    }

    public class Classe
    {
        public int codigo { get; set; }
        public string nome { get; set; }
    }

    public class ComplementosTabelado
    {
        public int codigo { get; set; }
        public int valor { get; set; }
        public string nome { get; set; }
        public string descricao { get; set; }
    }

    public class Formato
    {
        public int codigo { get; set; }
        public string nome { get; set; }
    }

    public class Hit
    {
        public string _index { get; set; }
        public string _type { get; set; }
        public string _id { get; set; }
        public double _score { get; set; }
        public Source _source { get; set; }
        public Total total { get; set; }
        public double max_score { get; set; }
        public List<Hit> hits { get; set; }
    }

    public class Movimento
    {
        public List<ComplementosTabelado> complementosTabelados { get; set; }
        public int codigo { get; set; }
        public string nome { get; set; }
        public DateTime dataHora { get; set; }
    }

    public class OrgaoJulgador
    {
        public int codigoMunicipioIBGE { get; set; }
        public int codigo { get; set; }
        public string nome { get; set; }
    }

    public class Root
    {
        public int took { get; set; }
        public bool timed_out { get; set; }
        public Shards _shards { get; set; }
        public Hits hits { get; set; }
    }

    public class Shards
    {
        public int total { get; set; }
        public int successful { get; set; }
        public int skipped { get; set; }
        public int failed { get; set; }
    }

    public class Sistema
    {
        public int codigo { get; set; }
        public string nome { get; set; }
    }

    public class Source
    {
        public string numeroProcesso { get; set; }
        public Classe classe { get; set; }
        public Sistema sistema { get; set; }
        public Formato formato { get; set; }
        public string tribunal { get; set; }
        public DateTime dataHoraUltimaAtualizacao { get; set; }
        public string grau { get; set; }

        [JsonProperty("@timestamp")]
        public DateTime timestamp { get; set; }
        public DateTime dataAjuizamento { get; set; }
        public List<Movimento> movimentos { get; set; }
        public string id { get; set; }
        public int nivelSigilo { get; set; }
        public OrgaoJulgador orgaoJulgador { get; set; }
        public List<Assunto> assuntos { get; set; }
    }

    public class Total
    {
        public int value { get; set; }
        public string relation { get; set; }
    }

}
