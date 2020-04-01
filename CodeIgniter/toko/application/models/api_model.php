<?php
	class api_model extends CI_Model
{
	function get_all()
	{
		$this->db->order_by('id_barang', 'DESC');
		return $this->db->get('barang');
	}

	function get_by_id($id)
	{
		$this->db->where("id_barang", $id);
		$query = $this->db->get('barang');
		return $query->result_array();
	}
}